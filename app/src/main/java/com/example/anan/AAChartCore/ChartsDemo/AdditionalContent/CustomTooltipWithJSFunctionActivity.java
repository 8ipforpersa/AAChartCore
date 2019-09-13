package com.example.anan.AAChartCore.ChartsDemo.AdditionalContent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anan.AAChartCore.AAChartCoreLib.AAChartConfiger.AAChartModel;
import com.example.anan.AAChartCore.AAChartCoreLib.AAChartConfiger.AAChartView;
import com.example.anan.AAChartCore.AAChartCoreLib.AAChartConfiger.AAOptionsConstructor;
import com.example.anan.AAChartCore.AAChartCoreLib.AAChartConfiger.AASeriesElement;
import com.example.anan.AAChartCore.AAChartCoreLib.AAChartEnum.AAChartStackingType;
import com.example.anan.AAChartCore.AAChartCoreLib.AAChartEnum.AAChartSymbolStyleType;
import com.example.anan.AAChartCore.AAChartCoreLib.AAChartEnum.AAChartType;
import com.example.anan.AAChartCore.AAChartCoreLib.AAOptionsModel.AAOptions;
import com.example.anan.AAChartCore.AAChartCoreLib.AAOptionsModel.AAStyle;
import com.example.anan.AAChartCore.AAChartCoreLib.AAOptionsModel.AATooltip;
import com.example.anan.AAChartCore.AAChartCoreLib.AATools.AAGradientColor;
import com.example.anan.AAChartCore.R;

public class CustomTooltipWithJSFunctionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tooltip_with_jsfunction);
        Intent intent = getIntent();
        String chartType = intent.getStringExtra("chartType");

        AAOptions aaOptions = configureTheChartOptions(chartType);

        AAChartView aaChartView = findViewById(R.id.AAChartView);
        aaChartView.aa_drawChartWithChartOptions(aaOptions);

    }

    AAOptions configureTheChartOptions(String chartType) {
        switch (chartType) {
            case "formatterFunction1": return customAreaChartTooltipStyleWithFormatterFunction1();
            case "formatterFunction2": return customAreaChartTooltipStyleWithFormatterFunction2();
            case "formatterFunction3": return customAreaChartTooltipStyleWithFormatterFunction3();
            case "formatterFunction4": return customAreaChartTooltipStyleWithFormatterFunction4();
            case "formatterFunction5": return customBoxplotTooltipContent();

        }
        return customAreaChartTooltipStyleWithFormatterFunction1();
    }

    AAOptions customAreaChartTooltipStyleWithFormatterFunction1() {
        AAChartModel aaChartModel = new AAChartModel()
                .chartType(AAChartType.Area)//图形类型
                .title("近三个月金价起伏周期图")//图表主标题
                .subtitle("金价(元/克)")//图表副标题
                .markerSymbolStyle(AAChartSymbolStyleType.BorderBlank)//折线连接点样式为外边缘空白
                .dataLabelsEnabled(false)
                .categories(new String[]{
                        "10-01","10-02","10-03","10-04","10-05","10-06","10-07","10-08","10-09","10-10","10-11",
                        "10-12","10-13","10-14","10-15","10-16","10-17","10-18","10-19","10-20","10-21","10-22",
                        "10-23","10-024","10-25","10-26","10-27","10-28","10-29","10-30","10-31","11-01","11-02",
                        "11-03","11-04","11-05","11-06","11-07","11-08","11-09","11-10","11-11","11-12","11-13",
                        "11-14","11-15","11-16","11-17","11-18","11-19","11-20","11-21","11-22","11-23","11-024",
                        "11-25","11-26","11-27","11-28","11-29","11-30","12-01","12-02","12-03","12-04","12-05",
                        "12-06","12-07","12-08","12-09","12-10","12-11","12-12","12-13","12-14","12-15","12-16",
                        "12-17","12-18","12-19","12-20","12-21","12-22","12-23","12-024","12-25","12-26","12-27",
                        "12-28","12-29","12-30"})
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("2020")
                                .lineWidth(3f)
                                .color("#FFD700"/*纯金色*/)
                                .fillOpacity(0.5f)
                                .data(new Object[]{
                                1.51, 6.7, 0.94, 1.44, 1.6, 1.63, 1.56, 1.91, 2.45, 3.87, 3.24, 4.90, 4.61, 4.10,
                                4.17, 3.85, 4.17, 3.46, 3.46, 3.55, 3.50, 4.13, 2.58, 2.28, 1.51, 12.7, 0.94, 1.44,
                                18.6, 1.63, 1.56, 1.91, 2.45, 3.87, 3.24, 4.90, 4.61, 4.10, 4.17, 3.85, 4.17, 3.46,
                                3.46, 3.55, 3.50, 4.13, 2.58, 2.28, 1.33, 4.68, 1.31, 1.10, 13.9, 1.10, 1.16, 1.67,
                                2.64, 2.86, 3.00, 3.21, 4.14, 4.07, 3.68, 3.11, 3.41, 3.25, 3.32, 3.07, 3.92, 3.05,
                                2.18, 3.24, 3.23, 3.15, 2.90, 1.81, 2.11, 2.43, 5.59, 3.09, 4.09, 6.14, 5.33, 6.05,
                                5.71, 6.22, 6.56, 4.75, 5.27, 6.02, 5.48})
                });

        AATooltip aaTooltip = new AATooltip()
                .useHTML(true)
                .formatter(" function () {\n" +
                        "        return ' 🌕 🌖 🌗 🌘 🌑 🌒 🌓 🌔 <br/> '\n" +
                        "        + ' Support JavaScript Function Just Right Now !!! <br/> '\n" +
                        "        + ' The Gold Price For <b>2020 '\n" +
                        "        +  this.x\n" +
                        "        + ' </b> Is <b> '\n" +
                        "        +  this.y\n" +
                        "        + ' </b> Dollars ';\n" +
                        "        }")
                .valueDecimals(2)//设置取值精确到小数点后几位//设置取值精确到小数点后几位
                .backgroundColor("#000000")
                .borderColor("#000000")
                .style(new AAStyle()
                        .color("#FFD700")
                        .fontSize(12.f)
                );
        AAOptions aaOptions = AAOptionsConstructor.configureChartOptions(aaChartModel);
        aaOptions.tooltip(aaTooltip);
        return aaOptions;
    }

    AAOptions customAreaChartTooltipStyleWithFormatterFunction2() {
        AASeriesElement element1 = new AASeriesElement()
                .name("🐶狗子")
                .lineWidth(5f)
                .fillOpacity(0.5f)
                .data(new Object[]{0.45, 0.43, 0.50, 0.55, 0.58, 0.62, 0.83, 0.39, 0.56, 0.67, 0.50, 0.34, 0.50, 0.67, 0.58, 0.29, 0.46, 0.23, 0.47, 0.46, 0.38, 0.56, 0.48, 0.36});
        AASeriesElement element2 = new AASeriesElement()
                .name("🌲树木")
                .lineWidth(5f)
                .fillOpacity(0.5f)
                .data(new Object[]{0.38, 0.31, 0.32, 0.32, 0.64, 0.66, 0.86, 0.47, 0.52, 0.75, 0.52, 0.56, 0.54, 0.60, 0.46, 0.63, 0.54, 0.51, 0.58, 0.64, 0.60, 0.45, 0.36, 0.67});

        AAChartModel aaChartModel = new AAChartModel()
                .chartType(AAChartType.Area)//图形类型
                .title("2014 ~ 2020 汪星人生存指数")//图表主标题
                .subtitle("数据来源：www.无任何可靠依据.com")//图表副标题
                .markerSymbolStyle(AAChartSymbolStyleType.BorderBlank)//折线连接点样式为外边缘空白
                .dataLabelsEnabled(false)
                .colorsTheme(new Object[]{"#ff0000","#0000ff"})
                .stacking(AAChartStackingType.Normal)
                .series(new AASeriesElement[]{element1, element2});


        AATooltip aaTooltip = new AATooltip()
                .useHTML(true)
                .formatter("function () {\n" +
                        "        var s = '第' + '<b>' +  this.x + '</b>' + '年' + '<br/>';\n" +
                        "        var colorDot1 = '<span style=\\\"' + 'color:red; font-size:13px\\\"' + '>◉</span> ';\n" +
                        "        var colorDot2 = '<span style=\\\"' + 'color:blue; font-size:13px\\\"' + '>◉</span> ';\n" +
                        "        var s1 = colorDot1  + this.points[0].series.name + ': ' + this.points[0].y + '只' + '<br/>';\n" +
                        "        var s2 =  colorDot2 + this.points[1].series.name + ': ' + this.points[1].y + '棵';\n" +
                        "        s += s1 + s2;\n" +
                        "        return s;\n" +
                        "    }")
               ;
        AAOptions aaOptions = AAOptionsConstructor.configureChartOptions(aaChartModel);
        aaOptions.tooltip(aaTooltip);
        return aaOptions;
    }

    AAOptions customAreaChartTooltipStyleWithFormatterFunction3() {
        AASeriesElement[] seriesElements = new AASeriesElement[]{
                new AASeriesElement()
                        .name("上市")
                        .data(new Object[]{0,0,7}),
                new AASeriesElement()
                        .name("中止")
                        .data(new Object[]{4,5,1}),
                new AASeriesElement()
                        .name("无进展")
                        .data(new Object[]{2,0,1}),
                new AASeriesElement()
                        .name("进行中")
                        .data(new Object[]{3,5,2}),

        };

        AAChartModel aaChartModel = new AAChartModel()
                .chartType(AAChartType.Area)//图形类型
                .title("2014 ~ 2020 汪星人生存指数")//图表主标题
                .subtitle("数据来源：www.无任何可靠依据.com")//图表副标题
                .markerSymbolStyle(AAChartSymbolStyleType.BorderBlank)//折线连接点样式为外边缘空白
                .dataLabelsEnabled(false)
                .categories(new String[]{"临床一期","临床二期","临床三期"})
                .series(seriesElements);

        AATooltip aaTooltip = new AATooltip()
                .useHTML(true)
                .formatter("function () {\n" +
                        "        var colorDot0 = '<span style=\\\"' + 'color:red; font-size:13px\\\"' + '>◉</span> ';\n" +
                        "        var colorDot1 = '<span style=\\\"' + 'color:mediumspringgreen; font-size:13px\\\"' + '>◉</span> ';\n" +
                        "        var colorDot2 = '<span style=\\\"' + 'color:deepskyblue; font-size:13px\\\"' + '>◉</span> ';\n" +
                        "        var colorDot3 = '<span style=\\\"' + 'color:sandybrown; font-size:13px\\\"' + '>◉</span> ';\n" +
                        "        var colorDotArr = [];\n" +
                        "        colorDotArr.push(colorDot0);\n" +
                        "        colorDotArr.push(colorDot1);\n" +
                        "        colorDotArr.push(colorDot2);\n" +
                        "        colorDotArr.push(colorDot3);\n" +
                        "        var wholeContentString = this.points[0].x + '<br/>';\n" +
                        "        for (var i = 0;i < 4;i++) {\n" +
                        "            var yValue = this.points[i].y;\n" +
                        "            if (yValue != 0) {\n" +
                        "                var prefixStr = colorDotArr[i];\n" +
                        "                wholeContentString += prefixStr + this.points[i].series.name + ': ' + this.points[i].y + '<br/>';\n" +
                        "            }\n" +
                        "        }\n" +
                        "        return wholeContentString;\n" +
                        "    }")
                ;
        AAOptions aaOptions = AAOptionsConstructor.configureChartOptions(aaChartModel);
        aaOptions.tooltip(aaTooltip);
        return aaOptions;
    }

    AAOptions customAreaChartTooltipStyleWithFormatterFunction4() {
        AASeriesElement element1 = new AASeriesElement()
                .name("Predefined symbol")
                .data(new Object[]{0.45, 0.43, 0.50, 0.55, 0.58, 0.62, 0.83, 0.39, 0.56, 0.67, 0.50, 0.34, 0.50, 0.67, 0.58, 0.29, 0.46, 0.23, 0.47, 0.46, 0.38, 0.56, 0.48, 0.36});

        AASeriesElement element2 = new AASeriesElement()
                .name("Image symbol")
                .data(new Object[]{0.38, 0.31, 0.32, 0.32, 0.64, 0.66, 0.86, 0.47, 0.52, 0.75, 0.52, 0.56, 0.54, 0.60, 0.46, 0.63, 0.54, 0.51, 0.58, 0.64, 0.60, 0.45, 0.36, 0.67});

        AASeriesElement element3 = new AASeriesElement()
                .name("Base64 symbol (*)")
                .data(new Object[]{0.46, 0.32, 0.53, 0.58, 0.86, 0.68, 0.85, 0.73, 0.69, 0.71, 0.91, 0.74, 0.60, 0.50, 0.39, 0.67, 0.55, 0.49, 0.65, 0.45, 0.64, 0.47, 0.63, 0.64});

        AASeriesElement element4 = new AASeriesElement()
                .name("Custom symbol")
                .data(new Object[]{0.60, 0.51, 0.52, 0.53, 0.64, 0.84, 0.65, 0.68, 0.63, 0.47, 0.72, 0.60, 0.65, 0.74, 0.66, 0.65, 0.71, 0.59, 0.65, 0.77, 0.52, 0.53, 0.58, 0.53});


        AAChartModel aaChartModel = new AAChartModel()
                .chartType(AAChartType.Areaspline)//图形类型
                .title("")//图表主标题
                .subtitle("")//图表副标题
                .markerSymbolStyle(AAChartSymbolStyleType.BorderBlank)//折线连接点样式为外边缘空白
                .dataLabelsEnabled(false)
                .colorsTheme(new Object[]{"#04d69f","#1e90ff","#ef476f","#ffd066",})
                .stacking(AAChartStackingType.Normal)
                .markerRadius(0f)
                .series(new AASeriesElement[]{element1, element2, element3, element4});


        AATooltip aaTooltip = new AATooltip()
                .useHTML(true)
                .formatter("function () {\n" +
                        "        var colorsArr = [];\n" +
                        "        colorsArr.push(\"mediumspringgreen\");\n" +
                        "        colorsArr.push(\"deepskyblue\");\n" +
                        "        colorsArr.push(\"red\");\n" +
                        "        colorsArr.push(\"sandybrown\");\n" +
                        "        var wholeContentString ='<span style=\\\"' + 'color:lightGray; font-size:13px\\\"' + '>◉ Time: ' + this.x + ' year</span><br/>';\n" +
                        "        for (var i = 0;i < 4;i++) {\n" +
                        "            var thisPoint = this.points[i];\n" +
                        "            var yValue = thisPoint.y;\n" +
                        "            if (yValue != 0) {\n" +
                        "                var spanStyleStartStr = '<span style=\\\"' + 'color:'+ colorsArr[i] + '; font-size:13px\\\"' + '>◉ ';\n" +
                        "                var spanStyleEndStr = '</span> <br/>';\n" +
                        "                wholeContentString += spanStyleStartStr + thisPoint.series.name + ': ' + thisPoint.y + '℃' + spanStyleEndStr;\n" +
                        "            }\n" +
                        "        }\n" +
                        "        return wholeContentString;\n" +
                        "    }")
                .backgroundColor("#050505")
                .borderColor("#050505")
                ;
        AAOptions aaOptions = AAOptionsConstructor.configureChartOptions(aaChartModel);
        aaOptions.tooltip(aaTooltip);
        return aaOptions;
    }

    AAOptions customBoxplotTooltipContent() {
        AAChartModel aaChartModel = new AAChartModel()
                .chartType(AAChartType.Boxplot)
                .title("BOXPLOT CHART")
                .subtitle("virtual data")
                .yAxisTitle("℃")
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("Observed Data")
                                .color("#ef476f")
                                .fillColor(AAGradientColor.deepSeaColor())
                                .data( new Object[][] {
                                {760, 801, 848, 895, 965},
                                {733, 853, 939, 980, 1080},
                                {714, 762, 817, 870, 918},
                                {724, 802, 806, 871, 950},
                                {834, 836, 864, 882, 910}
                        })
                        ,
                });

        String pointFormatStr =
                "◉</span> <b> {series.name}</b><br/>"
                        +  "最大值: {point.high}<br/>"
                        + "Q2: {point.q3}<br/>"
                        + "中位数: {point.median}<br/>"
                        +  "Q1: {point.q1}<br/>"
                        + "最小值: {point.low}<br/>";

        AATooltip aaTooltip = new AATooltip()
                .useHTML(true)
                .headerFormat("<em>实验号码： {point.key}</em><br/>")
                .pointFormat(pointFormatStr)
                .valueDecimals(2)//设置取值精确到小数点后几位//设置取值精确到小数点后几位
                .backgroundColor("#000000")
                .borderColor("#000000")
                .style(new AAStyle()
                        .color("#1e90ff")
                        .fontSize(12.f)
                );
        AAOptions aaOptions = AAOptionsConstructor.configureChartOptions(aaChartModel);
        aaOptions.tooltip(aaTooltip);
        return aaOptions;
    }

}
