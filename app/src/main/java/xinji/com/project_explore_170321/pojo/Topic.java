package xinji.com.project_explore_170321.pojo;

/**
 * Created by Administrator on 2017/3/24.
 */

public class Topic {


    /**
     * id : 350434
     * title : 银行借记卡不用了把钱取光后扔掉就 ok 了吗？
     * url : http://www.v2ex.com/t/350434
     * content : 因为要离开上海，不知道银行卡的正确处理姿势是怎样？

     目前有好几张借记卡，大概有三类，现在都已经把余额取光，好像都开通过网银。第一类是无年费也没开通短信通知的，直接剪掉应该没问题吧？第二类是有短信通知的，好像是 2 块／月，网上好像说这类借记卡不会自动销户？需要取消掉短信通知？那我直接剪掉呢？第三类是招商的金卡，好像有月费，如果直接剪掉呢？

     跪求大神指导
     * content_rendered : <p>因为要离开上海，不知道银行卡的正确处理姿势是怎样？</p>
     <p>目前有好几张借记卡，大概有三类，现在都已经把余额取光，好像都开通过网银。第一类是无年费也没开通短信通知的，直接剪掉应该没问题吧？第二类是有短信通知的，好像是 2 块／月，网上好像说这类借记卡不会自动销户？需要取消掉短信通知？那我直接剪掉呢？第三类是招商的金卡，好像有月费，如果直接剪掉呢？</p>
     <p>跪求大神指导</p>

     * replies : 93
     * member : {"id":173837,"username":"hanzichi","tagline":"","avatar_mini":"//v2ex.assets.uxengine.net/avatar/faad/a1f4/173837_mini.png?m=1471237748","avatar_normal":"//v2ex.assets.uxengine.net/avatar/faad/a1f4/173837_normal.png?m=1471237748","avatar_large":"//v2ex.assets.uxengine.net/avatar/faad/a1f4/173837_large.png?m=1471237748"}
     * node : {"id":12,"name":"qna","title":"问与答","title_alternative":"Questions and Answers","url":"http://www.v2ex.com/go/qna","topics":84472,"avatar_mini":"//v2ex.assets.uxengine.net/navatar/c20a/d4d7/12_mini.png?m=1488428101","avatar_normal":"//v2ex.assets.uxengine.net/navatar/c20a/d4d7/12_normal.png?m=1488428101","avatar_large":"//v2ex.assets.uxengine.net/navatar/c20a/d4d7/12_large.png?m=1488428101"}
     * created : 1490530804
     * last_modified : 1490530804
     * last_touched : 1490602510
     */

    private int id;
    private String title;
    private String url;
    private String content;
    private String content_rendered;
    private int replies;
    /**
     * id : 173837
     * username : hanzichi
     * tagline :
     * avatar_mini : //v2ex.assets.uxengine.net/avatar/faad/a1f4/173837_mini.png?m=1471237748
     * avatar_normal : //v2ex.assets.uxengine.net/avatar/faad/a1f4/173837_normal.png?m=1471237748
     * avatar_large : //v2ex.assets.uxengine.net/avatar/faad/a1f4/173837_large.png?m=1471237748
     */

    private Member member;
    /**
     * id : 12
     * name : qna
     * title : 问与答
     * title_alternative : Questions and Answers
     * url : http://www.v2ex.com/go/qna
     * topics : 84472
     * avatar_mini : //v2ex.assets.uxengine.net/navatar/c20a/d4d7/12_mini.png?m=1488428101
     * avatar_normal : //v2ex.assets.uxengine.net/navatar/c20a/d4d7/12_normal.png?m=1488428101
     * avatar_large : //v2ex.assets.uxengine.net/navatar/c20a/d4d7/12_large.png?m=1488428101
     */

    private Node node;
    private int created;
    private int last_modified;
    private int last_touched;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(int last_modified) {
        this.last_modified = last_modified;
    }

    public int getLast_touched() {
        return last_touched;
    }

    public void setLast_touched(int last_touched) {
        this.last_touched = last_touched;
    }

    public static class MemberBean {
        private int id;
        private String username;
        private String tagline;
        private String avatar_mini;
        private String avatar_normal;
        private String avatar_large;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public String getAvatar_mini() {
            return avatar_mini;
        }

        public void setAvatar_mini(String avatar_mini) {
            this.avatar_mini = avatar_mini;
        }

        public String getAvatar_normal() {
            return avatar_normal;
        }

        public void setAvatar_normal(String avatar_normal) {
            this.avatar_normal = avatar_normal;
        }

        public String getAvatar_large() {
            return avatar_large;
        }

        public void setAvatar_large(String avatar_large) {
            this.avatar_large = avatar_large;
        }
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", content_rendered='" + content_rendered + '\'' +
                ", replies=" + replies +
                ", member=" + member +
                ", node=" + node +
                ", created=" + created +
                ", last_modified=" + last_modified +
                ", last_touched=" + last_touched +
                '}';
    }

    public static class NodeBean {
        private int id;
        private String name;
        private String title;
        private String title_alternative;
        private String url;
        private int topics;
        private String avatar_mini;
        private String avatar_normal;
        private String avatar_large;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_alternative() {
            return title_alternative;
        }

        public void setTitle_alternative(String title_alternative) {
            this.title_alternative = title_alternative;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getTopics() {
            return topics;
        }

        public void setTopics(int topics) {
            this.topics = topics;
        }

        public String getAvatar_mini() {
            return avatar_mini;
        }

        public void setAvatar_mini(String avatar_mini) {
            this.avatar_mini = avatar_mini;
        }

        public String getAvatar_normal() {
            return avatar_normal;
        }

        public void setAvatar_normal(String avatar_normal) {
            this.avatar_normal = avatar_normal;
        }

        public String getAvatar_large() {
            return avatar_large;
        }

        public void setAvatar_large(String avatar_large) {
            this.avatar_large = avatar_large;
        }
    }
}
