package portaltek.cleancode.api.web.dto;

public class ServerResponse {
	
	private String message;

	public ServerResponse(String message) {
		super();
		this.message = message;
	}

	public ServerResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
