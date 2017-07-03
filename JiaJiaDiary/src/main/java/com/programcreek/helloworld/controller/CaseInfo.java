package com.programcreek.helloworld.controller;

public class CaseInfo {

    private int Case_ID;
    private String addr1;
    private String Addr_kind;
    
    public CaseInfo() {
	}
    
	public CaseInfo(int case_ID, String addr1, String addr_kind) {
		Case_ID = case_ID;
		this.addr1 = addr1;
		Addr_kind = addr_kind;
	}

	public int getCase_ID() {
		return Case_ID;
	}

	public void setCase_ID(int case_ID) {
		Case_ID = case_ID;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr_kind() {
		return Addr_kind;
	}

	public void setAddr_kind(String addr_kind) {
		Addr_kind = addr_kind;
	}
    
    
}
