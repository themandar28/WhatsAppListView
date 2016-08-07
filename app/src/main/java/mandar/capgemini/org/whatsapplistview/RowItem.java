package mandar.capgemini.org.whatsapplistview;

/**
 * Created by mandar on 8/7/2016.
 */
public class RowItem {

    private String contact_name;
    private int profile_pic;
    private String status;
    private String contact_type;

    public RowItem(String contact_name, String contact_type, int profile_pic, String status) {
        this.contact_name = contact_name;
        this.contact_type = contact_type;
        this.profile_pic = profile_pic;
        this.status = status;
    }

    public String getContact_type() {
        return contact_type;
    }

    public void setContact_type(String contact_type) {
        this.contact_type = contact_type;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public int getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(int profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
