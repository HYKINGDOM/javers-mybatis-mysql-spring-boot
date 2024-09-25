package org.java.temporary.notepad.javers.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 达人信息对象 creator_info
 * @author kscs
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(value = "creator_info")
public class CreatorInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 达人ID
     */
    @Id
    @Column(value = "creator_id")
    private String creatorId;

    /**
     * 达人名称
     */
    private String creatorName;

    /**
     * 达人昵称
     */
    private String creatorNickname;

    /**
     * 达人头像
     */
    private String creatorPortrait;

    /**
     * MCN签约
     */
    private String mcnContract;

    /**
     * 达人标签
     */
    private String creatorCategories;

    /**
     * 带货方式
     */
    private String ecommerceType;

    /**
     * 达人认证
     */
    private String creatorVerification;

    /**
     * 达人简介
     */
    private String description;

    /**
     * 主页地址
     */
    private String homepage;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 达人国家
     */
    private String country;

    /**
     * 机构名称
     */
    private String capName;

    /**
     * 添加日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addTime;

    /**
     * 来源平台
     */
    private String sourcePlatform;

    /**
     * 粉丝数
     */
    private Long fansNum;

    /**
     * 累计关注数
     */
    private Long followers;

    /**
     * 累计点赞数
     */
    private Long likes;

    /**
     * 累计视频数
     */
    private Long videos;

    /**
     * 累计带货直播数
     */
    @Column(value = "livestreamings")
    private Long livestreamings;

    /**
     * 视频GPM-最小
     */
    private Double videoGpmMin;

    /**
     * 视频GPM-最大
     */
    private Double videoGpmMax;

    /**
     * 直播GPM-最小
     */
    private Long liveGpmMin;

    /**
     * 直播GPM-最大
     */
    private Long liveGpmMax;

    /**
     * 本国排名
     */
    private Long nationalRank;

    /**
     * 累计关联店铺数
     */
    private Long relatedShops;

    /**
     * 累计带货商品数
     */
    private Long promotedProducts;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop1;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop1En;

    /**
     * 达人TOP1带货类目占比
     */
    private Long productCategoriesProportionTop1;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop2;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop2En;

    /**
     * 达人TOP1带货类目占比
     */
    private Long productCategoriesProportionTop2;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop3;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop3En;

    /**
     * 达人TOP1带货类目占比
     */
    private Long productCategoriesProportionTop3;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop4;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop4En;

    /**
     * 达人TOP1带货类目占比
     */
    private Long productCategoriesProportionTop4;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop5;

    /**
     * 达人TOP1带货类目名称
     */
    private String productCategoriesTop5En;

    /**
     * 达人TOP1带货类目占比
     */
    private Long productCategoriesProportionTop5;

    /**
     * 粉丝18-24年龄占比
     */
    @Column(value = "fans_18_24_percent")
    private Long fans1824Percent;

    /**
     * 粉丝25-34年龄占比
     */
    @Column(value = "fans_25_34_percent")
    private Long fans2534Percent;

    /**
     * 粉丝35+年龄占比
     */
    @Column(value = "fans_35_above_percent")
    private Long fans35AbovePercent;

    /**
     * 女性占比
     */
    private Long femalePercent;

    /**
     * 男性占比
     */
    private Long malePercent;

    /**
     * 近30条视频播放数
     */
    @Column(value = "recent_30_videos_views")
    private Long recent30VideosViews;

    /**
     * 近30条视频点赞数
     */
    @Column(value = "recent_30_videos_likes")
    private Long recent30VideosLikes;

    /**
     * 近30条视频评论数
     */
    @Column(value = "recent_30_videos_comments")
    private Long recent30VideosComments;

    /**
     * 近30条视频分享数
     */
    @Column(value = "recent_30_videos_shares")
    private Long recent30VideosShares;

    /**
     * 近30天GMV
     */
    @Column(value = "recent_30_days_gmv")
    private Long recent30DaysGmv;

    /**
     * 近7日粉丝增量
     */
    @Column(value = "videoslikes_gained_7days")
    private Long videoslikesGained7days;

    /**
     * 近7日带货直播数
     */
    @Column(value = "ecommerce_lives_7days")
    private Long ecommerceLives7days;

    /**
     * 近7日视频数
     */
    @Column(value = "videos_7days")
    private Long videos7days;

    /**
     * 近7日视频点赞增量
     */
    @Column(value = "followers_gained_7days")
    private Long followersGained7days;

    /**
     * 近7日视频IPM
     */
    @Column(value = "video_ipm_7days")
    private Long videoIpm7days;

    /**
     * 近28天带货视频数
     */
    @Column(value = "ecommerce_videos_28days")
    private Long ecommerceVideos28days;

    /**
     * 近28天视频带货商品数
     */
    @Column(value = "products_promoted_in_videos_28days")
    private Long productsPromotedInVideos28days;

    /**
     * 粉丝主要年龄(18-24,25-34,35+)
     */
    @Column(value = "fans_main_age")
    private String fansMainAge;

    /**
     * 粉丝主要性别(女,男)
     */
    @Column(value = "fans_main_sex")
    private String fansMainSex;

    /**
     * 近28天视频带货总GMV
     */
    @Column(value = "video_gmv_28days")
    private Double videoGmv28days;

    /**
     * 近28天直播带货总GMV
     */
    @Column(value = "live_gmv_28days")
    private Double liveGmv28days;

    /**
     * 近28天带货总GMV
     */
    @Column(value = "total_gmv_28days")
    private Double totalGmv28days;

    /**
     * 最大销量
     */
    @Column(value = "product_ecommerce_orders_max")
    private Double productEcommerceOrdersMax;

    /**
     * 爬取时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date crawTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 累计带货总GMV
     */
    @Column(value = "total_gmv_all")
    private Double totalGmvAll;

    /**
     * 累计带货视频数
     */
    @Column(value = "ecommerce_videos")
    private Long ecommerceVideos;

    /**
     * 近60天带货视频数
     */
    @Column(value = "ecommerce_videos_60days")
    private Long ecommerceVideos60days;

    /**
     * 近60天视频带货GMV
     */
    @Column(value = "recent_60_days_gmv")
    private Double recent60DaysGmv;

    /**
     * 近90天带货视频数
     */
    @Column(value = "ecommerce_videos_90days")
    private Long ecommerceVideos90days;

    /**
     * 近90天视频带货GMV
     */
    @Column(value = "recent_90_days_gmv")
    private Double recent90DaysGmv;

    /**
     * instagram账号名称
     */
    @Column(value = "instagram_username")
    private String instagramUsername;

    /**
     * instagram主页
     */
    @Column(value = "instagram_link")
    private String instagramLink;

    /**
     * youtube主页
     */
    @Column(value = "youtube_link")
    private String youtubeLink;

    /**
     * 所属youtube频道
     */
    @Column(value = "youtube_channel_title")
    private String youtubeChannelTitle;

    /**
     * 是否绑定(已绑定)
     */
    @Column(value = "bound_status")
    private String boundStatus;

    /**
     * 是否分佣达人:0不分佣，1分佣
     */
    @Column(value = "is_commission_daren")
    private Integer isCommissionDaren;
    /**
     * 近7天视频带货总GMV
     */
    @Column(value = "video_gmv_7days")
    private Double videoGmv7days;
    /**
     * 近7天带货总GMV
     */
    @Column(value = "total_gmv_7days")
    private Double totalGmv7days;
    /**
     * 近14天视频带货总GMV
     */
    @Column(value = "video_gmv_14days")
    private Double videoGmv14days;
    /**
     * 近14天带货总GMV
     */
    @Column(value = "total_gmv_14days")
    private Double totalGmv14days;
    /**
     * 近7天视频播放中位数
     */
    @Column(value = "median_watch_pv_video_7d")
    private Integer medianWatchPvVideo7d;
    /**
     * 近14天视频播放中位数
     */
    @Column(value = "median_watch_pv_video_14d")
    private Integer medianWatchPvVideo14d;
    /**
     * 近28天视频播放中位数
     */
    @Column(value = "median_watch_pv_video_28d")
    private Integer medianWatchPvVideo28d;
}
