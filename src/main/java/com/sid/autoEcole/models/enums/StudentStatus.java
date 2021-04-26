package com.sid.autoEcole.models.enums;

public enum StudentStatus {
	
	    ACTIF(0),
	    NOTACTIF(1),
	    FAILED_EXAM(2);

	    private int value;

	    StudentStatus(int value) {
	        this.value = value;
	    }

	    public static StudentStatus valueOf(int value) {
	        for (StudentStatus status : StudentStatus.values()) {
	            if (status.getValue() == value) {
	                return status;
	            }
	        }
	        return null;
	    }

	    public int getValue() {
	        return value;
	    }

}
