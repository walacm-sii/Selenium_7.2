package tests;

import data.CustomUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ModalDialogPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class ModalDialogTest extends BaseTest {

    private ModalDialogPage modalDialogPage;
    private CustomUser customUser;

    @BeforeEach
    public void testSetup() {
        modalDialogPage = new ModalDialogPage(driver);
        customUser = new CustomUser();
    }

    @Test
    public void addingUserShouldWorkCorrect() {
        log.debug("Executing test: {}", new Object(){}.getClass().getEnclosingMethod().getName());

        modalDialogPage.clickCreateNewUserButton()
                .fillCreateNewUserForm(customUser)
                .clickCreateNewAccountButton();

        assertThat(modalDialogPage.getListOfAddedUsers().stream()
                .anyMatch(user -> user.getText().contentEquals(customUser.name() + " " + customUser.email() + " " + customUser.password()))).isTrue();
    }
}
