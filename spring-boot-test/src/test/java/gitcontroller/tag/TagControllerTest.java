package gitcontroller.tag;

import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)

@SpringBootTest
@AutoConfigureMockMvc
public class TagControllerTest {

    private final MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );

    @Autowired
    private MockMvc mvc;

    @Test
    public void tagControllerGetReturnsTags() throws Exception {
        String expected = new GsonBuilder().create().toJson(TagController.testTags);

        mvc.perform(MockMvcRequestBuilders.get("/tag").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expected)));
    }

    @Test
    public void tagControllerPutIsInvalid() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/tag").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void tagControllerDeleteIsInvalid() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/tag").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void tagControllerPostNoValueIsInvalid() throws Exception {
        String iAmTheTagValue = "iAmTheTagValue";
        mvc.perform(MockMvcRequestBuilders.post("/tag", iAmTheTagValue).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void tagControllerPostWithValueIsOk() throws Exception {
        final String iAmTheBranch = "iAmTheBranch";
        final String iAmTheTagValue = "iAmTheTagValue";
        final TagRequest input = new TagRequest(iAmTheBranch, iAmTheTagValue);
        final String content = new GsonBuilder().create().toJson(input);

        final TagResponse expected = new TagResponse(iAmTheTagValue, "Tag Created");

        mvc.perform(MockMvcRequestBuilders
                .post("/tag")
                .content(content)
                .contentType(contentType)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expected)));
    }
}