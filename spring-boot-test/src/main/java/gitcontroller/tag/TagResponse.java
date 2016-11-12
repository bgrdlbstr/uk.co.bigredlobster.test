package gitcontroller.tag;

import static com.google.common.base.Preconditions.checkNotNull;

public class TagResponse {
    public final String tagName;
    public final String msg;

    public TagResponse(final String tagName, final String msg) {
        this.tagName = checkNotNull(tagName);
        this.msg = checkNotNull(msg);
    }

    public TagResponse(final String tagName) {
        this.tagName = checkNotNull(tagName);
        this.msg = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagResponse that = (TagResponse) o;

        if (!tagName.equals(that.tagName)) return false;
        return msg.equals(that.msg);

    }

    @Override
    public int hashCode() {
        int result = tagName.hashCode();
        result = 31 * result + msg.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TagResponse{" +
                "tagName='" + tagName + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
