package javawizards.surveywzrd.users;

public class LoginResult {

    private AuthToken authToken;
    private boolean isOwner;


    public LoginResult(AuthToken authToken, boolean isOwner) {
        this.authToken = authToken;
        this.isOwner = isOwner;
    }

    public AuthToken getAuthToken() {
        return authToken;
    }

    public void setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }
}
