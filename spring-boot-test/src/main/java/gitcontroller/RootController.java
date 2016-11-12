package gitcontroller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RootController {

    static final  String INVALID_PATH = "Invalid Path";

    @RequestMapping("/")
    public String index() {
        return INVALID_PATH;
    }
}