package eccezioni;

public class ErrorRequestException extends Exception {
	public ErrorRequestException() {
		super("ERROR:Richiesta non consentita");
	}
	public ErrorRequestException(String msg) {
		super(msg);
	}

}
