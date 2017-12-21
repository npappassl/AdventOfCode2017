package com.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day2CorruptionChecksum {
    private List<List<Integer>> spreadsheet;
    private Function<List<String>, List<Integer>> convertToIntegerListLambda = x -> x.stream().map(Integer::parseInt).collect(Collectors.toList());

    public Day2CorruptionChecksum(String spreadsheet){

        this.spreadsheet = parseSpreadSheet(spreadsheet);
    }
    public static void main(String[] args) throws Exception {
        Day2CorruptionChecksum app = new Day2CorruptionChecksum("1640	590	93	958	73	1263	1405	1363	737	712	1501	390	68	1554	959	79\n"+
                "4209	128	131	2379	2568	2784	2133	145	3618	1274	3875	158	1506	3455	1621	3799\n" +
                "206	1951	2502	2697	2997	74	76	78	1534	81	2775	2059	3026	77	2600	3067\n"     +
                "373	1661	94	102	2219	1967	1856	417	1594	75	100	2251	2200	1825	1291	1021\n"     +
                "57	72	51	1101	1303	60	1227	421	970	1058	138	333	1320	1302	402	1210\n"                     +
                "4833	5427	179	3934	4533	5124	4832	2088	94	200	199	1114	4151	1795	208	3036\n"     +
                "759	876	110	79	1656	1691	185	544	616	312	757	1712	92	97	1513	1683\n"                         +
                "1250	1186	284	107	1190	1233	573	1181	1041	655	132	547	395	146	119	515\n"                      +
                "505	1726	79	180	86	1941	1597	1785	1608	1692	968	1177	94	184	91	31\n"               +
                "1366	2053	1820	1570	70	506	53	415	717	1263	82	366	74	1255	2020	1985\n"                 +
                "2365	5585	2285	4424	5560	3188	3764	187	88	223	1544	5023	4013	5236	214	196\n"  +
                "1487	1305	1359	1615	6579	2623	4591	150	5030	188	146	4458	5724	5828	1960	221\n"+
                "3114	688	3110	334	1921	153	4083	131	2234	3556	3573	3764	127	919	3293	104\n"          +
                "1008	78	1196	607	135	1409	296	475	915	157	1419	1304	153	423	163	704\n"                          +
                "235	4935	4249	3316	1202	221	1835	380	249	1108	1922	5607	4255	238	211	3973\n"     +
                "1738	207	179	137	226	907	1468	1341	1582	1430	851	213	393	1727	1389	632");
        System.out.println(app.checkSum());
        System.out.println(app.checkSumDiv());
    }
    private List<List<Integer>> parseSpreadSheet(String spreadsheet){
        List<String> temp = Arrays.asList(spreadsheet.split("\n"));
        List<List<Integer>> parsedSpreadsheet = temp.stream()
                .map((String x) -> Arrays.asList(x.split("\t")))
                .map(convertToIntegerListLambda)
                .collect(Collectors.toList());

        return parsedSpreadsheet;
    }

    private List<Integer> convertToIntegerList(List<String> list){
        return  list.stream().map( Integer::parseInt).collect(Collectors.toList());
    }
    private int checkSum(){
        int sum = 0;
        for(List<Integer> list:spreadsheet){
            sum += rowCheck(list);
        }
        return sum;
    }
    private int checkSumDiv() throws Exception {
        int sum = 0;
        for(List<Integer> list:spreadsheet){
            sum += rowCheckDivision(list);
        }
        return sum;
    }
    private int rowCheck(List<Integer> list){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i: list){
            if(max<= i) max = i;
            if(min>= i) min = i;
        }
        return max-min;
    }
    private int rowCheckDivision(List<Integer> list) throws Exception {
        for(int i=0;i<list.size();i++){
            int cur = list.get(i);
            for(int j=0;j<list.size();j++){
                if(i==j) continue;
                int cursor = list.get(j);
                if(cur>=cursor){
                    if(cur%cursor==0) return cur/cursor;
                }
                if(cursor%cur==0) return cursor/cur;
            }
        }
        throw new Exception("Divisors not found");
    }
}
