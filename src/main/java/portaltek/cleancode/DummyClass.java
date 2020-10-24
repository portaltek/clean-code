package portaltek.cleancode;


import org.springframework.security.core.userdetails.UsernameNotFoundException;


class DummyClass {

    final String NOT_FOUND = "No user found with username '%s'.";

    public void myPublicLevelMethod(StringBuilder sb) throws UsernameNotFoundException {
        sb.append(1);
        myPackageLevelMethod(sb);
        myPackageLevelMethod(sb);
        myProtectedLevelMethod(sb);

    }

    void myPackageLevelMethod(StringBuilder sb){
        sb.append(2);
    }

    protected void myProtectedLevelMethod(StringBuilder sb){
        sb.append(3);
    }




}


