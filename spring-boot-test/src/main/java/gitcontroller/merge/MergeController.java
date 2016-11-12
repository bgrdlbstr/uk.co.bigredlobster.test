package gitcontroller.merge;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merge")
public class MergeController {
    @RequestMapping(method = RequestMethod.POST)
    public String merge(@RequestBody String branchOrTag) {
        return "Merging with " + branchOrTag;
    }
}