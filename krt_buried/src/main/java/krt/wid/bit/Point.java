package krt.wid.bit;

/**
 * @author: MaGua
 * @create_on:2021/8/19 9:40
 * @description
 */
public class Point {

    /**
     * actCode : string
     * actHow : string
     * actJson : string
     * actTime : 2021-08-19T01:35:46.780Z
     * addrLat : 0
     * addrLng : 0
     * itemCode : string
     * krtNo : 0
     * level : 0
     * puuid : string
     * rootUuid : string
     * shareKrtNo : 0
     * source : string
     * takeKrtNo : 0
     * themeCode : string
     * times : 0
     * tranLevel : 0
     * tranPuuid : string
     * tranRootUuid : string
     * tranSource : string
     * tranUrl : string
     * tranUuid : string
     * uuid : string
     */

    /**
     * 活动ID 运营活动关联的id
     */
    private String actCode;
    /**
     * 用户进行事件的方式 （设备、环境）
     */
    private String actHow;
    /**
     * actJson 携带信息的参数（需要提供的业务数据）
     */
    private String actJson;
    /**
     * 动作时间 YYYY-MM-DD HH:mm:ss
     */
    private String actTime;
    /**
     * 纬度 百度坐标
     */
    private int addrLat;
    /**
     * 经度 百度坐标
     */
    private int addrLng;
    /**
     * 动作标识
     * 标识库在后台查看
     * 后台地址 http://172.30.1.149:8080/dataopt/item
     * 账号 admin
     * 密码 123456
     */
    private String itemCode;
    /**
     * 当前操作的用户的标识
     */
    private int krtNo;
    /**
     * 动作层级（用户在一个访问周期中，动作的步数层级）
     */
    private int level;
    /**
     *
     */
    private String puuid;
    /**
     * 根uuid 用户在一个访问周期中的根标识，通常为全新启动时初始化一次
     */
    private String rootUuid;
    /**
     * 传播者用户标识
     */
    private int shareKrtNo;
    /**
     * 数据来源
     * IOS|Android|wechat_applet|alipay_applet|code|log
     */
    private String source = "Android";
    /**
     * 接收者用户标识
     */
    private int takeKrtNo;
    /**
     * 主题ID
     */
    private String themeCode;
    /**
     * 次数，短时间内重复次数可以合并
     */
    private int times;
    /**
     * 传播级别
     */
    private int tranLevel;
    /**
     * 传播链上一级唯一标识，上一个传播者分享的uuid
     */
    private String tranPuuid;
    /**
     * 传播链初始标识，此传播链第一个传播者分享的uuid
     */
    private String tranRootUuid;
    /**
     * 传播途径
     * 微信公众号文章，短信，分享
     * 可能后台会配置字段
     */
    private String tranSource;
    /**
     * 传播的url
     */
    private String tranUrl;
    /**
     * 本次传播链当前的uuid
     * krtNo + url md5加密
     */
    private String tranUuid;
    /**
     * 当前动作标识
     */
    private String uuid;

    public String getActCode() {
        return actCode;
    }

    public void setActCode(String actCode) {
        this.actCode = actCode;
    }

    public String getActHow() {
        return actHow;
    }

    public void setActHow(String actHow) {
        this.actHow = actHow;
    }

    public String getActJson() {
        return actJson;
    }

    public void setActJson(String actJson) {
        this.actJson = actJson;
    }

    public String getActTime() {
        return actTime;
    }

    public void setActTime(String actTime) {
        this.actTime = actTime;
    }

    public int getAddrLat() {
        return addrLat;
    }

    public void setAddrLat(int addrLat) {
        this.addrLat = addrLat;
    }

    public int getAddrLng() {
        return addrLng;
    }

    public void setAddrLng(int addrLng) {
        this.addrLng = addrLng;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getKrtNo() {
        return krtNo;
    }

    public void setKrtNo(int krtNo) {
        this.krtNo = krtNo;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getRootUuid() {
        return rootUuid;
    }

    public void setRootUuid(String rootUuid) {
        this.rootUuid = rootUuid;
    }

    public int getShareKrtNo() {
        return shareKrtNo;
    }

    public void setShareKrtNo(int shareKrtNo) {
        this.shareKrtNo = shareKrtNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getTakeKrtNo() {
        return takeKrtNo;
    }

    public void setTakeKrtNo(int takeKrtNo) {
        this.takeKrtNo = takeKrtNo;
    }

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getTranLevel() {
        return tranLevel;
    }

    public void setTranLevel(int tranLevel) {
        this.tranLevel = tranLevel;
    }

    public String getTranPuuid() {
        return tranPuuid;
    }

    public void setTranPuuid(String tranPuuid) {
        this.tranPuuid = tranPuuid;
    }

    public String getTranRootUuid() {
        return tranRootUuid;
    }

    public void setTranRootUuid(String tranRootUuid) {
        this.tranRootUuid = tranRootUuid;
    }

    public String getTranSource() {
        return tranSource;
    }

    public void setTranSource(String tranSource) {
        this.tranSource = tranSource;
    }

    public String getTranUrl() {
        return tranUrl;
    }

    public void setTranUrl(String tranUrl) {
        this.tranUrl = tranUrl;
    }

    public String getTranUuid() {
        return tranUuid;
    }

    public void setTranUuid(String tranUuid) {
        this.tranUuid = tranUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
