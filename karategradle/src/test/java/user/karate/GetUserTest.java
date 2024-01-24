package user.karate;


import com.intuit.karate.junit5.Karate;

public class GetUserTest {

    @Karate.Test
    Karate testGetUser() {
        return Karate.run("classpath:features/getUser.feature").tags("@getUserJson");
    }

}
