package com.wsd.algorithm.basic;

import com.google.common.base.Charsets;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sdwang on 2019/12/28.
 */
public class TestLz2sStsb {

    public static void main(String[] args) throws DocumentException, IOException {
        Map<String, String> dataDic = new HashMap<>();
        dataDic.put("拖欠的工资", "0200503001");
        dataDic.put("拖欠的工资计算公式", "0200503002");
        dataDic.put("加班工资（休息日）", "0200503003");
        dataDic.put("加班工资（休息日）计算公式", "0200503004");
        dataDic.put("加班工资（法定休假日）", "0200503005");
        dataDic.put("加班工资（法定休假日）计算公式", "0200503006");
        dataDic.put("加班工资（延时）", "0200503007");
        dataDic.put("加班工资（延时）计算公式", "0200503008");
        dataDic.put("违法解除劳动合同经济赔偿金", "0200503011");
        dataDic.put("违法解除劳动合同经济赔偿金计算公式", "0200503012");
        dataDic.put("未休年休假工资", "0200503013");
        dataDic.put("未休年休假工资计算公式", "0200503014");
        dataDic.put("二倍工资差额", "0200503015");
        dataDic.put("二倍工资差额计算公式", "0200503016");
        dataDic.put("医疗费用", "0200503017");
        dataDic.put("医疗费用计算公式", "0200503018");
        dataDic.put("住院期间伙食补助费", "0200503019");
        dataDic.put("住院期间伙食补助费计算公式", "0200503020");
        dataDic.put("到统筹地区以外就医的交通费", "0200503021");
        dataDic.put("到统筹地区以外就医的交通费计算公式", "0200503022");
        dataDic.put("到统筹地区以外就医的食宿费", "0200503023");
        dataDic.put("到统筹地区以外就医的食宿费计算公式", "0200503024");
        dataDic.put("康复费", "0200503025");
        dataDic.put("康复费计算公式", "0200503026");
        dataDic.put("劳动能力鉴定费", "0200503027");
        dataDic.put("劳动能力鉴定费计算公式", "0200503028");
        dataDic.put("残疾辅助器具费", "0200503029");
        dataDic.put("残疾辅助器具费计算公式", "0200503030");
        dataDic.put("停工留薪期护理费", "0200503031");
        dataDic.put("停工留薪期护理费计算公式", "0200503032");
        dataDic.put("停工留薪期工资", "0200503033");
        dataDic.put("停工留薪期工资计算公式", "0200503034");
        dataDic.put("生活护理费", "0200503041");
        dataDic.put("生活护理费计算公式", "0200503042");
        dataDic.put("一次性伤残补助金", "0200503043");
        dataDic.put("一次性伤残补助金计算公式", "0200503044");
        dataDic.put("伤残津贴", "0200503045");
        dataDic.put("伤残津贴计算公式", "0200503046");
        dataDic.put("一次性工伤医疗补助金", "0200503047");
        dataDic.put("一次性工伤医疗补助金计算公式", "0200503048");
        dataDic.put("一次性伤残就业补助金", "0200503049");
        dataDic.put("一次性伤残就业补助金计算公式", "0200503050");
        dataDic.put("解除劳动合同经济补偿金", "0200503051");
        dataDic.put("解除劳动合同经济补偿金计算公式", "0200503052");
        dataDic.put("终止劳动合同经济补偿金", "0200503053");
        dataDic.put("终止劳动合同经济补偿金计算公式", "0200503054");

        String xmlContent = readTxt("D:\\data");
        String jsonContent = readTxt("D:\\json");

        boolean Failure = false;
        JSONObject resObject = new JSONObject(jsonContent);
        Document document = DocumentHelper.parseText(xmlContent);
        Element root = document.getRootElement();

        if (!resObject.get("code").equals(200)) {
            Failure = true;
        }

        JSONObject resData = (JSONObject) resObject.get("data");
        JSONArray pcxInfo = (JSONArray) resData.get("pcxInfo");
        for (Object o : pcxInfo) {
            JSONObject pcx = (JSONObject) o;
            String code = dataDic.get(pcx.get("pcxmc"));

            Stack<Element> stack = new Stack<>();
            stack.add(root);
            Element node = null;
            while (!stack.isEmpty()) {
                node = stack.pop();
                String xmlCode = node.attributeValue("code");
                if (xmlCode != null && xmlCode.equals(code)) {
                    break;
                }

                List<Element> elements = node.elements();
                for (Element child : elements) {
                    stack.push(child);
                }
            }
            if (node == null) {
                Failure = true;
                break;
            }
        }
    }

    private static String readTxt(String fileName) throws IOException {
        File file = new File(fileName);
        StringBuilder sbf = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(file.toPath(), Charsets.UTF_8);
            lines.forEach(sbf::append);
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sbf.toString();
    }
}
