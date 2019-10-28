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
@JsonDeserialize(builder = AutoValue_ModelUser.Builder.class)
public abstract class ModelUser {

    @Nullable
    @JsonProperty("id")
    public abstract String id();
    
    @Nullable
    @JsonProperty("name")
    public abstract String name();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static interface Builder {
        public abstract Builder id(String value);

        public abstract Builder name(String value);

        public abstract ModelUser build();
    }

    
    public static Builder builder() {
        return new AutoValue_ModelUser.Builder();
    }
}
