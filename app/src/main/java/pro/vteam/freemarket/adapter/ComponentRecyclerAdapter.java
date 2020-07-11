package pro.vteam.freemarket.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import java.util.ArrayList;

import pro.vteam.freemarket.Constant;
import pro.vteam.freemarket.helper.RateOverviewSectionHelper;
import pro.vteam.freemarket.models.CommentVerticalCollection;
import pro.vteam.freemarket.models.Divider;
import pro.vteam.freemarket.models.EachItemOverview;
import pro.vteam.freemarket.R;
import pro.vteam.freemarket.models.Banner;
import pro.vteam.freemarket.models.BigPromotionBanner;
import pro.vteam.freemarket.models.Component;
import pro.vteam.freemarket.models.InlineAction;
import pro.vteam.freemarket.models.Item;
import pro.vteam.freemarket.models.ItemHeader;
import pro.vteam.freemarket.models.ItemOverview;
import pro.vteam.freemarket.models.Link;
import pro.vteam.freemarket.models.LinkVerticalCollection;
import pro.vteam.freemarket.models.OneRowBanners;
import pro.vteam.freemarket.models.OneRowItems;
import pro.vteam.freemarket.models.RatesOverview;
import pro.vteam.freemarket.utils.CustomItemDecoration;


public class ComponentRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Component> list;


    public ComponentRecyclerAdapter(Context context, ArrayList<Component> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        switch (viewType) {
            case Constant.BIG_PROMOTION_BANNER: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_big_promotion_banner, parent, false);
                return new BigPromotionBannerViewHolder(view);

            }
            case Constant.ONE_ROW_ITEMS: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_one_row_items, parent, false);
                return new OneRowItemsViewHolder(view);
            }

            case Constant.ONE_ROW_BANNERS: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_one_row_banners, parent, false);
                return new OneRowBannersViewHolder(view);
            }

            case Constant.LINK_VERTICAL_COLLECTION: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_link_vertical_collection, parent, false);
                return new LinkVerticalCollectionViewHolder(view);
            }

            case Constant.ITEM_HEADER: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_item_header, parent, false);
                return new ItemHeaderViewHolder(view);
            }
            case Constant.ITEM_OVERVIEW: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_item_overview, parent, false);
                return new ItemOverviewViewHolder(view);
            }
            case Constant.DIVIDER: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_divider, parent, false);
                return new DividerViewHolder(view);
            }

            case Constant.RATES_OVERVIEW: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_rates_overview, parent, false);
                return new RatesOverviewViewHolder(view);
            }

            case Constant.COMMENT_VERTICAL_COLLECTION: {
                View view = LayoutInflater.from(context).inflate(R.layout.model_comment_vertical_collection, parent, false);
                return new CommentVerticalCollectionViewHolder(view);
            }
            default:
                View view = LayoutInflater.from(context).inflate(R.layout.model_unsuported_component, parent, false);
                return new UnSupportedComponentViewHolder(view);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        Gson gson = new Gson();
        switch (viewType) {

            case Constant.BIG_PROMOTION_BANNER:
                String jsonPromotionObject = gson.toJson(list.get(position).getObject());
                BigPromotionBanner bigPromotionBanner = gson.fromJson(jsonPromotionObject, BigPromotionBanner.class);
                ((BigPromotionBannerViewHolder) holder).setData(bigPromotionBanner);
                break;

            case Constant.ONE_ROW_BANNERS:
                String jsonBannerObject = gson.toJson(list.get(position).getObject());
                OneRowBanners oneRowBanners = gson.fromJson(jsonBannerObject, OneRowBanners.class);
                ((OneRowBannersViewHolder) holder).setData(oneRowBanners);
                break;

            case Constant.ONE_ROW_ITEMS:
                String jsonItemObject = gson.toJson(list.get(position).getObject());
                OneRowItems oneRowItems = gson.fromJson(jsonItemObject, OneRowItems.class);
                ((OneRowItemsViewHolder) holder).setData(oneRowItems);
                break;

            case Constant.LINK_VERTICAL_COLLECTION:
                String jsonLinkObject = gson.toJson(list.get(position).getObject());
                LinkVerticalCollection linkVerticalCollection = gson.fromJson(jsonLinkObject, LinkVerticalCollection.class);
                ((LinkVerticalCollectionViewHolder) holder).setData(linkVerticalCollection);
                break;

            case Constant.ITEM_HEADER:
                String jsonItemHeaderObject = gson.toJson(list.get(position).getObject());
                ItemHeader itemHeader = gson.fromJson(jsonItemHeaderObject, ItemHeader.class);
                ((ItemHeaderViewHolder) holder).setData(itemHeader);
                break;


            case Constant.ITEM_OVERVIEW:
                String jsonItemOverviewObject = gson.toJson(list.get(position).getObject());
                ItemOverview itemOverview = gson.fromJson(jsonItemOverviewObject, ItemOverview.class);
                ((ItemOverviewViewHolder) holder).setData(itemOverview);
                break;

            case Constant.DIVIDER:
                String jsonDividerObject = gson.toJson(list.get(position).getObject());
                Divider divider = gson.fromJson(jsonDividerObject, Divider.class);
                ((DividerViewHolder) holder).setData(divider);
                break;

            case Constant.RATES_OVERVIEW:
                String jsonRatesOverviewObject = gson.toJson(list.get(position).getObject());
                RatesOverview ratesOverview = gson.fromJson(jsonRatesOverviewObject, RatesOverview.class);
                ((RatesOverviewViewHolder) holder).setData(ratesOverview);
                break;

            case Constant.COMMENT_VERTICAL_COLLECTION:
                String jsonCommentVerticalCollectionObject = gson.toJson(list.get(position).getObject());
                CommentVerticalCollection commentVerticalCollection = gson.fromJson(jsonCommentVerticalCollectionObject, CommentVerticalCollection.class);
                ((CommentVerticalCollectionViewHolder) holder).setData(commentVerticalCollection);
                break;
            default:
                ((UnSupportedComponentViewHolder) holder).txt_description.setText("این کامپوننت ساپورت نمی شود لطفا اپلیکیشن را آپدیت کنید.");


        }
    }


    @Override
    public int getItemViewType(int position) {
        String type = list.get(position).getType();
        switch (type) {

            case "OneRowBanners":
                return Constant.ONE_ROW_BANNERS;

            case "OneRowItems":
                return Constant.ONE_ROW_ITEMS;

            case "BigPromotionBanner":
                return Constant.BIG_PROMOTION_BANNER;

            case "LinkVerticalCollection":
                return Constant.LINK_VERTICAL_COLLECTION;


            case "ItemHeader":
                return Constant.ITEM_HEADER;

            case "ItemOverview":
                return Constant.ITEM_OVERVIEW;

            case "Divider":
                return Constant.DIVIDER;

            case "RatesOverview":
                return Constant.RATES_OVERVIEW;

            case "CommentVerticalCollection":
                return Constant.COMMENT_VERTICAL_COLLECTION;

            default:
                return Constant.UN_SUPPORTED_COMPONENT;
        }

    }


    @Override

    public int getItemCount() {
        return list.size();
    }


    public static class UnSupportedComponentViewHolder extends RecyclerView.ViewHolder {

        TextView txt_description;

        UnSupportedComponentViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_description = itemView.findViewById(R.id.txt_description);
        }

    }


    public class BigPromotionBannerViewHolder extends RecyclerView.ViewHolder {

        ImageView img_promotion_banner;
        ImageView img_promotion_icon;
        TextView txt_promotion_name;
        TextView txt_bigPromotionTag;
        Button btn_inlineAction;
        ImageView img_bullet;
        LinearLayoutCompat bigPromotionTagLayout;
        ConstraintLayout actionbarConstraintLayout;


        BigPromotionBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_bigPromotionTag = itemView.findViewById(R.id.txt_bigPromotionTag);
            img_promotion_banner = itemView.findViewById(R.id.img_bigPromotionBanner);
            img_promotion_icon = itemView.findViewById(R.id.img_bigPromotionIcon);
            txt_promotion_name = itemView.findViewById(R.id.txt_promotion_name);
            btn_inlineAction = itemView.findViewById(R.id.btn_inlineAction);
            bigPromotionTagLayout = itemView.findViewById(R.id.tag_linearLayout);
            img_bullet = itemView.findViewById(R.id.img_bullet);
            actionbarConstraintLayout = itemView.findViewById(R.id.actionbarConstraintLayout);


        }


        void setData(BigPromotionBanner bigPromotionBanner) {


            if (bigPromotionBanner.getTag().equals("") || bigPromotionBanner.getTag() == null) {
                txt_bigPromotionTag.setVisibility(View.GONE);
            } else {
                txt_bigPromotionTag.setTextColor(Color.parseColor(bigPromotionBanner.getTag().getTextColor()));
                txt_bigPromotionTag.setText(bigPromotionBanner.getTag().getTitle());
                bigPromotionTagLayout.setBackgroundColor(Color.parseColor(bigPromotionBanner.getTag().getBackgroundColor()));
                img_bullet.setColorFilter(Color.argb(255, 255, 255, 255));
                img_bullet.setColorFilter(Color.GREEN, android.graphics.PorterDuff.Mode.MULTIPLY);
            }
            btn_inlineAction.setTextColor(Color.parseColor(bigPromotionBanner.getInlineAction().getTextColor()));
            btn_inlineAction.setBackgroundColor(Color.parseColor(bigPromotionBanner.getInlineAction().getBackgroundColor()));
            actionbarConstraintLayout.setBackgroundColor(Color.parseColor(bigPromotionBanner.getBigPromotionBannerActionbar().getBackgroundColor()));

            ((ConstraintLayout.LayoutParams) img_promotion_banner.getLayoutParams()).dimensionRatio
                    = bigPromotionBanner.getImage().getRatio().getConstraintDimensionRatio();
            if (bigPromotionBanner.getImage().getPath() != null) {
                Glide.with(context)
                        .load(bigPromotionBanner.getImage().getPath())
                        .centerCrop()
                        .into(img_promotion_banner);
            }


            ((ConstraintLayout.LayoutParams) img_promotion_icon.getLayoutParams()).dimensionRatio
                    = bigPromotionBanner.getItem().getIcon().getRatio().getConstraintDimensionRatio();


            int roundRadius = (int) context.getResources().getDimension(R.dimen.big_promotion_banner_icon_corner_radius);
            RequestOptions requestOptions = new RequestOptions().transform(new CenterCrop(), new RoundedCorners(roundRadius));


            Glide.with(context)
                    .load(bigPromotionBanner.getItem().getIcon().getPath())
                    .apply(requestOptions)
                    .into(img_promotion_icon);

            txt_promotion_name.setText(bigPromotionBanner.getItem().getTitle());

        }
    }


    public class OneRowBannersViewHolder extends RecyclerView.ViewHolder {

        TextView bannersTitle;
        TextView inlineActionText;
        RecyclerView bannerRecycler;
        ImageView icon_oneRowBannersInlineAction;
        ConstraintLayout bannersTitleConstraintLayout;
        CustomItemDecoration customItemDecoration;


        OneRowBannersViewHolder(@NonNull View itemView) {
            super(itemView);
            bannersTitle = itemView.findViewById(R.id.txt_banners_title);
            inlineActionText = itemView.findViewById(R.id.txt_oneRowBannersInlineAction);
            bannersTitleConstraintLayout = itemView.findViewById(R.id.bannersTitleConstraintLayout);
            bannerRecycler = itemView.findViewById(R.id.banner_recycler);

            if (customItemDecoration == null)
                setCustomItemDecoration(new CustomItemDecoration(context.getResources().getDimension(R.dimen.recycler_horizontal_margin)));

        }


        void setData(OneRowBanners oneRowBanners) {

            String oneRowBannersTitle = oneRowBanners.getTitle();
            InlineAction oneRowItemsInlineAction = oneRowBanners.getInlineAction();


            if ((oneRowBannersTitle == null || oneRowBannersTitle.equals("")) && oneRowItemsInlineAction == null) {
                bannersTitleConstraintLayout.setVisibility(View.GONE);

            } else if (oneRowBannersTitle == null || oneRowBannersTitle.equals("")) {
                bannersTitle.setVisibility(View.GONE);
                inlineActionText.setText(oneRowBanners.getInlineAction().getTitle());
                inlineActionText.setTextColor(Color.parseColor(oneRowBanners.getInlineAction().getTextColor()));
                inlineActionText.setBackgroundColor(Color.parseColor(oneRowBanners.getInlineAction().getBackgroundColor()));


            } else if (oneRowItemsInlineAction == null) {
                icon_oneRowBannersInlineAction.setVisibility(View.GONE);
                inlineActionText.setVisibility(View.GONE);
                bannersTitle.setText(oneRowBanners.getTitle());
                bannersTitleConstraintLayout.setClickable(false);
                bannersTitleConstraintLayout.setFocusable(false);

            } else {
                bannersTitleConstraintLayout.setBackgroundColor(Color.parseColor(oneRowBanners.getInlineAction().getBackgroundColor()));
                bannersTitle.setText(oneRowBanners.getTitle());
                inlineActionText.setText(oneRowBanners.getInlineAction().getTitle());

            }


            ArrayList<Banner> bannerList = oneRowBanners.getBanners();
            BannerAdapter bannerAdapter = new BannerAdapter(context, bannerList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            bannerRecycler.setLayoutManager(linearLayoutManager);
            bannerRecycler.setAdapter(bannerAdapter);
        }

        void setCustomItemDecoration(CustomItemDecoration customItemDecoration) {
            this.customItemDecoration = customItemDecoration;
            bannerRecycler.addItemDecoration(customItemDecoration);
        }


    }


    public class OneRowItemsViewHolder extends RecyclerView.ViewHolder {

        TextView itemsTitle;
        TextView txt_oneRowItemsInlineAction;
        ImageView icon_oneRowItemsInlineAction;
        RecyclerView itemsRecycler;
        CustomItemDecoration customItemDecoration;
        ConstraintLayout ConstraintLayout_title;

        OneRowItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            ConstraintLayout_title = itemView.findViewById(R.id.itemsTitleConstraintLayout);
            txt_oneRowItemsInlineAction = itemView.findViewById(R.id.txt_oneRowItemsInlineAction);
            icon_oneRowItemsInlineAction = itemView.findViewById(R.id.icon_oneRowItemsInlineAction);
            itemsTitle = itemView.findViewById(R.id.txt_items_title);
            ConstraintLayout_title = itemView.findViewById(R.id.itemsTitleConstraintLayout);
            itemsRecycler = itemView.findViewById(R.id.item_recycler);
            if (customItemDecoration == null)
                setCustomItemDecoration(new CustomItemDecoration(context.getResources().getDimension(R.dimen.recycler_horizontal_margin)));
        }

        void setData(OneRowItems oneRowItems) {

            String oneRowItemsTitle = oneRowItems.getTitle();
            InlineAction oneRowItemsInlineAction = oneRowItems.getInlineAction();


            if ((oneRowItemsTitle == null || oneRowItemsTitle.equals("")) && oneRowItemsInlineAction == null) {
                ConstraintLayout_title.setVisibility(View.GONE);


            } else if (oneRowItemsTitle == null || oneRowItemsTitle.equals("")) {
                itemsTitle.setVisibility(View.GONE);
                txt_oneRowItemsInlineAction.setText(oneRowItems.getInlineAction().getTitle());
                txt_oneRowItemsInlineAction.setTextColor(Color.parseColor(oneRowItems.getInlineAction().getTextColor()));
                ConstraintLayout_title.setBackgroundColor(Color.GREEN);


            } else if (oneRowItemsInlineAction == null) {
                icon_oneRowItemsInlineAction.setVisibility(View.GONE);
                txt_oneRowItemsInlineAction.setVisibility(View.GONE);
                itemsTitle.setText(oneRowItems.getTitle());
                ConstraintLayout_title.setClickable(false);
                ConstraintLayout_title.setFocusable(false);


            } else {
                ConstraintLayout_title.setBackgroundColor(Color.GREEN);
                itemsTitle.setText(oneRowItems.getTitle());
                txt_oneRowItemsInlineAction.setText(oneRowItems.getInlineAction().getTitle());

            }


            ArrayList<Item> items = oneRowItems.getItems();
            ItemAdapter itemAdapter = new ItemAdapter(context, items);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            itemsRecycler.setLayoutManager(linearLayoutManager);
            itemsRecycler.setAdapter(itemAdapter);
        }

        void setCustomItemDecoration(CustomItemDecoration customItemDecoration) {
            this.customItemDecoration = customItemDecoration;
            itemsRecycler.addItemDecoration(customItemDecoration);
        }
    }

    public class LinkVerticalCollectionViewHolder extends RecyclerView.ViewHolder {


        TextView linksTitle;
        TextView txt_moreAction;
        RecyclerView linksRecycler;

        public LinkVerticalCollectionViewHolder(@NonNull View itemView) {
            super(itemView);
            linksTitle = itemView.findViewById(R.id.title_links);
            txt_moreAction = itemView.findViewById(R.id.txt_more_action);
            linksRecycler = itemView.findViewById(R.id.recycler_links);
        }


        void setData(LinkVerticalCollection linkVerticalCollection) {


            ArrayList<Link> visibleList = new ArrayList<>();
            int maxCount = linkVerticalCollection.getMaxCount();

            if (linkVerticalCollection.getLinks().size() <= maxCount) {
                visibleList = linkVerticalCollection.getLinks();
                txt_moreAction.setVisibility(View.GONE);
            } else {


                txt_moreAction.setBackgroundColor(Color.parseColor(linkVerticalCollection.getInlineAction().getBackgroundColor()));
                txt_moreAction.setTextColor(Color.parseColor(linkVerticalCollection.getInlineAction().getTextColor()));
                for (int i = 0; i < maxCount; i++) {
                    visibleList.add(linkVerticalCollection.getLinks().get(i));
                }
            }


            linksTitle.setText(linkVerticalCollection.getTitle());
            LinkAdapter linkAdapter = new LinkAdapter(context, visibleList, linkVerticalCollection.getDivider());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            linksRecycler.setLayoutManager(linearLayoutManager);
            linksRecycler.setAdapter(linkAdapter);

        }
    }

    public class ItemHeaderViewHolder extends RecyclerView.ViewHolder {

        ImageView img_itemHeader;
        ImageView icon_itemHeader;
        TextView txt_titleItemHeader;
        TextView txt_companyItemHeader;
        Button btn_inlineActionItemHeader;


        ItemHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            img_itemHeader = itemView.findViewById(R.id.img_itemHeader);
            icon_itemHeader = itemView.findViewById(R.id.icon_itemHeader);
            txt_titleItemHeader = itemView.findViewById(R.id.txt_titleItemHeader);
            txt_companyItemHeader = itemView.findViewById(R.id.txt_companyItemHeader);
            btn_inlineActionItemHeader = itemView.findViewById(R.id.btn_inlineActionItemHeader);
        }

        void setData(ItemHeader itemHeader) {


            if (itemHeader.getImage() != null && itemHeader.getImage().getPath() != null) {
                Glide.with(context)
                        .load(itemHeader.getImage().getPath())
                        .centerCrop()
                        .into(img_itemHeader);

                ((ConstraintLayout.LayoutParams) img_itemHeader.getLayoutParams()).dimensionRatio
                        = itemHeader.getImage().getRatio().getConstraintDimensionRatio();
            }
            Glide.with(context)
                    .load(itemHeader.getItem().getIcon().getPath())
                    .into(icon_itemHeader);

            ((ConstraintLayout.LayoutParams) icon_itemHeader.getLayoutParams()).dimensionRatio
                    = itemHeader.getItem().getIcon().getRatio().getConstraintDimensionRatio();


            txt_titleItemHeader.setText(itemHeader.getItem().getTitle());
            txt_companyItemHeader.setText(itemHeader.getCompany().getTitle());
            btn_inlineActionItemHeader.setText(itemHeader.getInlineAction().getTitle());
            btn_inlineActionItemHeader.setTextColor(Color.parseColor(itemHeader.getInlineAction().getTextColor()));
            btn_inlineActionItemHeader.setBackgroundColor(Color.parseColor(itemHeader.getInlineAction().getBackgroundColor()));


        }
    }

    public class ItemOverviewViewHolder extends RecyclerView.ViewHolder {

        LinearLayoutCompat linearLayoutCompat;


        ItemOverviewViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutCompat = itemView.findViewById(R.id.item_overview_linearLayout);
        }

        void setData(ItemOverview itemOverview) {

            ArrayList<ItemOverview.ItemOverviewSection> itemOverviewSections = itemOverview.getItemOverviewSections();
            if (linearLayoutCompat.getChildCount() > 0)
                linearLayoutCompat.removeAllViews();
            LinearLayoutCompat.LayoutParams param = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);

            for (int i = 0; i < itemOverviewSections.size(); i++) {
                EachItemOverview eachItemOverview = new EachItemOverview(context);
                eachItemOverview.setLayoutParams(param);
                eachItemOverview.setTxt_title(itemOverviewSections.get(i).getTitle());
                eachItemOverview.setTxt_subTitle(itemOverviewSections.get(i).getSubTitle());
                linearLayoutCompat.addView(eachItemOverview);

                if (i == itemOverviewSections.size() - 1) {
                    eachItemOverview.setVisibilityDivider(View.GONE);
                }
            }


        }
    }

    public class DividerViewHolder extends RecyclerView.ViewHolder {

        View dividerView;

        public DividerViewHolder(@NonNull View itemView) {
            super(itemView);
            dividerView = itemView.findViewById(R.id.divider);
        }

        void setData(Divider divider) {

            dividerView.setBackgroundColor(Color.parseColor(divider.getColor()));

            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) dividerView.getLayoutParams();
            int rightMargin = divider.getMargin().getRightMargin().getQuantity();
            int leftMargin = divider.getMargin().getLeftMargin().getQuantity();
            params.setMargins(leftMargin, 0, rightMargin, 0);
            dividerView.setLayoutParams(params);
            dividerView.requestLayout();


        }
    }

    public class RatesOverviewViewHolder extends RecyclerView.ViewHolder {


        TextView txt_ratesTitle;
        TextView txt_ratesAverage;
        TextView txt_rateCount;
        GridLayout gridLayout;

        public RatesOverviewViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_ratesTitle = itemView.findViewById(R.id.title_ratesOverview);
            txt_ratesAverage = itemView.findViewById(R.id.txt_rateAverage);
            txt_rateCount = itemView.findViewById(R.id.txt_rateCount);
            gridLayout = itemView.findViewById(R.id.gridLayout);


        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        void setData(RatesOverview ratesOverview) {

            txt_ratesTitle.setText(ratesOverview.getTitle());
            txt_ratesAverage.setText(ratesOverview.getRateAverage());
            txt_rateCount.setText(ratesOverview.getRateCount());

            gridLayout.removeAllViews();

            ArrayList<RatesOverview.RatesOverviewSection> ratesOverviewSections = ratesOverview.getRatesOverviewSections();

            for (int i = 0; i < ratesOverviewSections.size(); i++) {
                ProgressBar progressBar = RateOverviewSectionHelper.createProgressBar(context, ratesOverviewSections.get(i).getPercent(), i, 0);
                gridLayout.addView(progressBar);
                TextView progressTitle = RateOverviewSectionHelper.createProgressTitle(context, ratesOverviewSections.get(i).getTitle(), i, 1);
                gridLayout.addView(progressTitle);
            }

        }
    }

    public class CommentVerticalCollectionViewHolder extends RecyclerView.ViewHolder{

        RecyclerView comment_recycler;

        public CommentVerticalCollectionViewHolder(@NonNull View itemView) {
            super(itemView);
            comment_recycler=itemView.findViewById(R.id.comment_recycler);
        }

        void setData(CommentVerticalCollection commentVerticalCollection){
            CommentAdapter commentAdapter=new CommentAdapter(context,commentVerticalCollection.getComments());
            comment_recycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
            comment_recycler.setAdapter(commentAdapter);
        }
    }


}


