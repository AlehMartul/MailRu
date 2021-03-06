package api;

import configuration.Configuration;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;

public class Builder {
    private URIBuilder uriBuilder;

    public Builder() {
    }

    public static class builder {
        private Builder apiBuilder;

        public builder(String method) throws URISyntaxException {
            apiBuilder = new Builder();
            apiBuilder.uriBuilder = new URIBuilder(String.format("https://api.vk.com/method/%s?", method));
        }

        public builder setOwnerID() {
            apiBuilder.uriBuilder.setParameter("owner_id", Configuration.getOwnerId());
            return this;
        }

        public builder setMessageText() {
            apiBuilder.uriBuilder.setParameter("message", Configuration.getMessageText());
            return this;
        }

        public builder setEditedMessageText() {
            apiBuilder.uriBuilder.setParameter("message", Configuration.getEditedMessageText());
            return this;
        }

        public builder setPostID(String postID) {
            apiBuilder.uriBuilder.setParameter("post_id", postID);
            return this;
        }

        public builder setAccessToken() {
            apiBuilder.uriBuilder
                    .setParameter("access_token", Configuration.getAccessToken())
                    .setParameter("v", Configuration.getVersion());
            return this;
        }

        public URIBuilder build() {
            return apiBuilder.uriBuilder;
        }
    }
}