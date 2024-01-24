package user.karate;


import com.intuit.karate.junit5.Karate;

public class DeleteUserTest {

    @Karate.Test
    Karate testDeleteUser() {
        return Karate.run("classpath:features/deleteUser.feature").tags("@deleteUserJson");
    }

}
