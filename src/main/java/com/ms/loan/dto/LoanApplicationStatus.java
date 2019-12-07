package com.ms.loan.dto;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Builder
@JsonInclude(Include.NON_NULL)
public class LoanApplicationStatus {
    String applicationId;
    Boolean passed;
}
