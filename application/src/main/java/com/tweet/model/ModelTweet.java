/**
 * 
 */
package com.tweet.model;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.auto.value.AutoValue;

/**
 * @author fajars
 * @version 1.0, Oct 28, 2019
 * @since
 */
@AutoValue
@JsonDeserialize(builder = AutoValue_ModelTweet.Builder.class)
public abstract class ModelTweet {

    @Nullable
    @JsonProperty("id_str")
    public abstract String id();

    @Nullable
    @JsonProperty("text")
    public abstract String text();

    @Nullable
    public abstract ModelUser user();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static interface Builder {
        public abstract Builder id(String value);

        public abstract Builder text(String value);

        public abstract Builder user(ModelUser value);

        public abstract ModelTweet build();
    }

    public static Builder builder() {
        return new AutoValue_ModelTweet.Builder();
    }

}
