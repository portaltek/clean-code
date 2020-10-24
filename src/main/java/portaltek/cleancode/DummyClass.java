package portaltek.cleancode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import portaltek.cleancode.module.security.spi.repo.model.User;
import portaltek.cleancode.module.security.spi.repo.repository.UserRepo;


class DummyClass {

    final UserRepo userRepo;
    final String NOT_FOUND = "No user found with username '%s'.";

    @Autowired
    public DummyClass(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void myPublicLevelMethod(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        user.setUsername(user.getUsername() + "2");
        myPackageLevelMethod(user, user);
        myPackageLevelMethod(user, user);
        userRepo.save(user);
    }

    void myPackageLevelMethod(User user, User user2){
        user.setUsername(user.getUsername() + "3");
    }

    protected void myProtectedLevelMethod(User user){
        user.setUsername(user.getUsername() + "3");
    }




}


