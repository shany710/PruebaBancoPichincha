package user.karate;


import com.intuit.karate.junit5.Karate;

public class UpdateUserTest {

    @Karate.Test
    Karate testUpdateUser() {
        return Karate.run("classpath:features/updateUser.feature").tags("@updateUserJson");
    }

}
