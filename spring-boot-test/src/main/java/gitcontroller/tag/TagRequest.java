package gitcontroller.tag;

import static com.google.common.base.Preconditions.checkNotNull;

class TagRequest {
    public final String branch;
    public final String tagValue;

    public TagRequest() {
        this.branch = "UNSET";
        this.tagValue = "UNSET";
    }

    public TagRequest(final String branch, final String tagValue) {
        this.branch = checkNotNull(branch);
        this.tagValue = checkNotNull(tagValue);
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagRequest that = (TagRequest) o;

        if (!branch.equals(that.branch)) return false;
        return tagValue.equals(that.tagValue);

    }

    @Override
    public int hashCode() {
        int result = branch.hashCode();
        result = 31 * result + tagValue.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TagRequest{" +
                "branch='" + branch + '\'' +
                ", tagValue='" + tagValue + '\'' +
                '}';
    }
}
