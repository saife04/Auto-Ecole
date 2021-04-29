package com.sid.autoEcole.app.models.enums;

public enum StudentStatus {
	
	    ACTIVE(0),
	    NOT_ACTIVE(1),
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
