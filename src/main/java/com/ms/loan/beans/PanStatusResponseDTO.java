package com.ms.loan.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PanStatusResponseDTO implements Serializable {

    private static final long serialVersionUID = 5984742845223111095L;

	@JsonProperty("exist")
    private boolean exist;

    @JsonProperty("id")
    private String id;

    @JsonProperty("panNo")
    private String panNo;

    @JsonProperty("panToken")
    private String panToken;

    @JsonProperty("title")
    private String title;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("middlename")
    private String middlename;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("issueDate")
    private String issueDate;
    
    @JsonProperty("ErrorDesc")
    private String errorDesc;
    
    @JsonProperty("ErrorCode")
    private String errorCode;

}
