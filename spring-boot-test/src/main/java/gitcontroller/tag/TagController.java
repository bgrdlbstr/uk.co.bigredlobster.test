package gitcontroller.tag;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.gson.GsonBuilder;
import gitcontroller.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.base.Preconditions.checkNotNull;

@RestController
@RequestMapping("/tag")
class TagController {
    private static final Logger log = LoggerFactory.getLogger(TagController.class);

    static final String INVALID_ACTION = "Invalid Action";
    static final String MISSING_PARAMETER = "Missing Parameter";
    static final String TAGGING_WITH = "Tagging with ";
    static final ImmutableList<String> testTags = ImmutableList.of(
            "1.1.1.1-tag",
            "1.1.1.2-tag",
            "2.1.1.1-tag",
            "3.1.1.1-tag"
    );

    @RequestMapping(method = RequestMethod.GET)
    public ImmutableList<String> get() {
        return testTags;
    }

    @RequestMapping(method = RequestMethod.POST)
    public TagResponse post(@RequestBody TagRequest tagRequest) {
        validate(tagRequest);
        return applyTag(tagRequest);
    }

    private TagResponse applyTag(@RequestBody TagRequest tagRequest) {
        log.error("TODO applyTag {}", tagRequest);  // TODO applyTag
        return new TagResponse(tagRequest.tagValue, "Tag Created");
    }

    private void validate(@RequestBody TagRequest tagRequest) {
        if(tagRequest == null) {
            log.warn("Received null tagRequest");
            throw new BadRequestException(MISSING_PARAMETER);
        }
        if (Strings.isNullOrEmpty(tagRequest.branch)) {
            log.warn("Received null or empty tagRequest.branch");
            throw new BadRequestException(MISSING_PARAMETER);
        }
        if (Strings.isNullOrEmpty(tagRequest.tagValue)) {
            log.warn("Received null or empty tagRequest.tagValue");
            throw new BadRequestException(MISSING_PARAMETER);
        }
    }
}