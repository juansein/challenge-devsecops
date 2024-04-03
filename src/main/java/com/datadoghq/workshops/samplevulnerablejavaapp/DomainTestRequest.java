package com.datadoghq.workshops.samplevulnerablejavaapp;

import lombok.Data;

@Data
public class DomainTestRequest {
  String secretKey = "A4DEfXDCL8ws1f7zgC08BWoFz1osgttnIR1mCxeZ";
  String domainName;
}
