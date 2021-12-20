package com.training.casestudy.library.error;

/**
 * @author ram
 */
public class CopyNotAvailableException extends RuntimeException {
    private static final long serialVersionUID = -3170205715922026587L;

    public CopyNotAvailableException() {
        super("No more copies of this book available");
    }
}
