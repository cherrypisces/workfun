package com.believe.we.string;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Concatenation {
	
	public static String parity(String msg) {
		String parityStr = null;
		int n = msg.hashCode();
		switch (n%2)
		{
			case 0:
				parityStr = "even";
				break;
			case 1:
				parityStr = "odd";
				break;
		}
		return parityStr;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(parity(""));
		/*
		String mango = "mango";
		String s = "abv" + mango + "def" + 47;
		System.out.println(s);
		
		String ss = "*******************";
		byte[] src = ss.getBytes();
		System.out.println(ss.length());
		System.out.println(src.length);
		
		String tt="com.ubs.orderstream.servers.tools.commandreplay.replay.CommandReplay";		
		System.out.println("tt.length: " + tt.length());
		
		tt="commandreplay/current/command.replay.properties";
		System.out.println("tt.length: " + tt.length());
		
		tt="commandlogutils/jars/orderstream_commandlogutils.jar";
		System.out.println("tt.length: " + tt.length());
		
		tt="commandlogutils/current/replay.jar";
		System.out.println("tt.length: " + tt.length());
		
		tt="cmdlog.clean.raw.log";
		System.out.println(tt.matches("cmdlog\\.\\w+\\.raw.log"));
		
		tt="com.ubs.orderstream.servers.publisher.file.instrument.supplemental.tradinglimits.TradingLimitsPublisher";
		System.out.println("tt.length: " + tt.length());
		
		tt="fileinstlimitpublisher/current/orderstream_fileinstlimitpublisher.zar";
		System.out.println("tt.length: " + tt.length());
		
		tt="fileinstlimitpublisher/current/dentsupb1.ini";
		System.out.println("tt.length: " + tt.length());
		
		long qty = 100000000;
		long  size = 1;
		System.out.println(1.0*size/qty);
		
		
		String logName="cmdlog.clean.raw.log.gz";
		if (logName.matches("^cmdlog.+raw.+$")) {
			System.out.println("match");
		}
		*/
		
	//	String FIX_MSG_PATTERN	= "(^[\\d:.]+.*FIXPUMP.*\\d: \\[.*\\] |\u0001|\u0001$)";    
	//	String message="16:49:35.768454 I FIXPUMP    fxcoms2: [FIXTX] 8=FIX.4.2^A9=312^A35=8^A43=N^A52=20140516-07:49:35.768^A122=20140516-07:49:35.768^A49=BMOMS^A56=FXCOMS^A34=990^A50=ubsc11^A57=mayuresh^A37=142008423^A11=S_5241674384740^A17=S-142008423-20140516-1^A20=0^A150=0^A39=0^A54=1^A38=1000.0000^A40=2^A59=0^A32=0.0000^A31=0.00^A151=1000.0000^A14=0.0000^A6=0.00^A55=EURUSD SPOT^A48=200000001^A22=x^A167=FOR^A44=1.31683^A10=115^A";
	//	String FIX_MSG_PATTERN	= "(^[\\d:.]+.*FIXPUMP.*\\d: |\\w+ \\[|\\[.*\\] |\u0001|\u0001$|\\] \\w+$)";    
	//	String message="16:49:36.198551 E FIXPUMP    fxcoms2: bad tag in repeating group [8=FIX.4.2|9=262|35=E|49=FXCOMS|56=BMOMS|34=394|52=20140516-07:49:35|50=mayuresh|66=Fri May 16 13:19:35 IST 2014|73=1|11=O_6204487488164|1=0230UA100581|21=1|22=x|38=100.12|40=2|44=1.39|48=200000001|54=1|59=0|60=20140516-07:49:35|167=FOR|847=151|848=L:1|9004=9|9645=2|9989=181011|10=030|] InternalCrossInst";
	/*	Pattern eventSplitPattern = Pattern.compile(FIX_MSG_PATTERN, 0);
		String[] fields = eventSplitPattern.split(message);
		for(int i=0; i<fields.length; i++)
			System.out.println("fields["+i+"]:" + fields[i]);
	*/
		///////////////////////////////////////////////////////////////////////////
		final byte[] noDataAvailable		= "No data available for validation".getBytes();
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*		String event = "19:40:04.598243 [INSTRUMENT SUPPL UPDATED  ] [seq=200290][src=limitpb1][id=4][ref=0][updateType=I][category=F][productType=1][masterId=32243976][TradingLimits<9964>={LimitBand<9965>[LimitBandId<9966>=1][LimitPriceLevel<9967>=30%][LimitQuantityLevel<9968>=1001][LimitConsiderationLevel<9969>=300000000],LimitBand<9965>[LimitBandId<9966>=2][LimitPriceLevel<9967>=50%][LimitQuantityLevel<9968>=4000][LimitConsiderationLevel<9969>=1000000000],LimitBand<9965>[LimitBandId<9966>=3][LimitQuantityLevel<9968>=5000][LimitConsiderationLevel<9969>=3000000000]}]";
//		String VERBOSE_EVENT_DELIM = "(^[\\d:.]+ \\[|^\\[|\\] \\[|\\]\\[|\\]$)";
//		String TTTTTTT_EVENT_DELIM = "(^[\\d:.]+ \\[|^\\[|\\] \\[|\\]\\[|\\{|\\],|\\[|\\]\\}\\]$)";

		
//		String event = "05:46:00.591669 [INSTRUMENT SUPPL UPDATED  ] [seq=275328][src=krlmtpb1][id=1][ref=0][updateType=U][category=F][productType=2][masterId=31677566][TradingLimits<9964>={LimitBand<9965>[LimitBandId<9966>=1][LimitQuantityLevel<9968>=1000][LimitConsiderationLevel<9969>=2000000000]}]";
		String DELIM = "(^[\\d:.]+ \\[|^\\[|\\] \\[|\\{|\\}\\]$)";
		Pattern eventSplitPattern = Pattern.compile(DELIM, 0);
		String[] strList = eventSplitPattern.split(event);
		for(String str : strList) {
			System.out.println(str);
		}
		
		String evtName = strList[1];
		String[] attr  = Pattern.compile("\\]\\[",0).split(strList[2]);
		String[] band  = Pattern.compile(",").split(strList[3]);
		
		System.out.println("~~~~~~~~~~~~~~~ Attrs ~~~~~~~~~~~~~~~~~");
		for(int i=0; i<attr.length; i++) {
			System.out.println(attr[i]);
		}
	
		System.out.println("~~~~~~~~~~~~~~ LimitBands ~~~~~~~~~~~~~~");
		for(int i=0; i<band.length; i++) {
			System.out.println("*************************************");
			System.out.println(band[i]);
			String[] limits = Pattern.compile("\\[|\\]\\[|\\]").split(band[i]);
			System.out.println(">>>>>>>>>");
			for(int j=0; j<limits.length; j++) {
				System.out.println(limits[j]);
			}
		}
		
			
		String tt = "TradingLimits<9964>=";
		int sepPos = tt.indexOf("=");
		String val = tt.substring(sepPos+1);
		System.out.println("val :" + val);
			
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Pattern attrNameSplitter = Pattern.compile("[<>]");
		String[] tt = attrNameSplitter.split("LimitBand<9965>");
		for(String str : tt) {
			System.out.println(str);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		*/
		
		final String FIX_MSG_PREFIX 	= "8=FIX";
//		final String FIX_MSG_PATTERN	= "(^[\\d:.]+.*FIXPUMP.*\\d: \\[.*\\] |\u0001|\u0001$)";
		final String FIX_MSG_PATTERN	= "(^[\\d:.]+.*FIXPUMP.*\\d: \\[[A-Z]+\\] |\u0001|\u0001$)";    
		
		String line="14:03:48.316791 I FIXPUMP    rtnet1: [FIXTX] 8=FIX.4.2^A9=318^A35=8^A43=N^A52=20140710-05:03:48^A122=20140710-05:03:48^A49=CMOMS^A56=RTNTQA^A34=967^A50=rtnet1^A57=43320420^A37=143156468^A11=D071000100411^A17=S-143156468-20140710-1^A20=0^A150=8^A39=8^A103=0^A54=1^A38=20000^A40=1^A15=CNY^A59=0^A32=0^A31=0.00^A151=0^A14=0^A58=[Scale0331] : EndTime is after exchange close time ^A6=0.00^A55=600000^A22= ^A167=CS^A10=214^A";
	//	String line="14:03:48.431165 I FIXPUMP    rtnet1: [FIXRX] 8=FIX.4.2^A9=154^A35=3^A34=966^A49=RTNTQA^A50=43320420^A52=20140710-05:03:48.935^A56=CMOMS^A57=rtnet1^A45=967^A58=Value is incorrect (out of range) for this tag^A371=22^A372=8^A373=5^A10=212^A";
	//	String line="14:03:35.570171 I FIXPUMP    rtnet1: [FIXRX] 8=FIX.4.2^A9=334^A35=D^A34=965^A49=RTNTQA^A50=43320420^A52=20140710-05:03:36.073^A56=CMOMS^A57=CMOMS^A116=43320420^A11=D071000100411^A15=CNY^A38=20000^A40=1^A54=1^A55=600000^A59=0^A60=20140710-05:03:35^A100=SS^A111=0^A126=20140710-07:05:00^A526=000000001201_ZY0000_100410^A6061=VWAP^A6062=20140710-05:03:00^A6063=20140710-07:00:00^A6064=33^A6065=3^A6075=N^A6076=N^A6297=Y^A6298=Y^A10=219^A";
	//	String line="10:39:44.970309 I FIXPUMP    sbij1: [FIXTX] 8=FIX.4.2^A9=177^A35=D^A43=N^A52=20140710-01:39:44.969^A122=20140710-01:39:44.969^A49=TD11746E^A56=TDJNX^A34=559^A11=01431550630000^A38=40^A54=1^A44=1221.00^A40=2^A59=0^A47=A^A60=20140710-01:39:44.969^A55=1305^A10=041^A";
		String[] fields = Pattern.compile(FIX_MSG_PATTERN, 0).split(line);
		
		int index = line.indexOf(FIX_MSG_PREFIX);
	//	String msgHeader = line.substring(0, index);
	////String msgBody	 = maskFields(fields);

	//	line = msgHeader + msgBody;
	//	System.out.println(line);
		
		long shares = 1;
		long closePx = 1100000L;
		final long orderConsideration = shares * (long)(((double)closePx) / 100000000); 
		System.out.println(orderConsideration);
		
		final long orderConsideration2 = (long)(((double)closePx) / 100000000 * shares); 
		System.out.println(orderConsideration2);
		
		System.out.println(Long.MAX_VALUE);
		
		System.out.println(Long.SIZE);
		
		long res_a 	= Integer.MAX_VALUE + (long)(Integer.MAX_VALUE);
		long res_m 	= Integer.MAX_VALUE * (long)(Integer.MAX_VALUE);
	//	long res2_a = Integer.MIN_VALUE + (long)(Integer.MIN_VALUE);
	//	long res2_m = Integer.MIN_VALUE * (long)(Integer.MIN_VALUE);
	//	long ress_m = Integer.MAX_VALUE * (long)(Integer.MIN_VALUE);
		
		System.out.println(Integer.MAX_VALUE + "   + = " + res_a + "   * = " + res_m);
	//	System.out.println(Integer.MIN_VALUE + "   + = " + res2_a+ "   * = " + res2_m);
	//	System.out.println(" Special * = " + ress_m);
		
		System.out.println(" Special max*max = " + (res_m+res_m));
	//	System.out.println(" Special min*min = " + (res2_m+res2_m));
	//	System.out.println(" Special max*min = " + (ress_m+ress_m));
		
		System.out.println(" Byte.Max = " + Byte.MAX_VALUE);
		
		long a = Long.MAX_VALUE;
		long b = Long.MAX_VALUE;
		
		long qty = 1121559500;
		long px  = (long)(0.011*10000000);
		long consideration = qty * (long)(((double)px) / 100000000); 
		System.out.println( "--->  " + consideration );
		
		//int l_32_a = ;
		//int h_32_a = ;
		String ttt = "price=92233720368.54775";
		System.out.println(ttt.contains("92233720368.54775"));
		System.out.println(Long.MAX_VALUE);
		
		HashMap<Integer, String> m = new HashMap<Integer, String>();
		TreeMap<Integer, String> t = new TreeMap<Integer, String>();
		
		String[] tt = {"tt1", "tt2"};
		for(String e: tt) {
			System.out.println(">>>>>>>" + TestTypes.valueOf(e));
		}
	}
	
	static enum TestTypes {
		tt1 {
			public byte getType() {
				return '1';
			}
		},
		
		tt2 {
			public byte getType() {
				return '2';
			}
		}
		
	}
	
	public void test() {
		getClass();
	}

	public static String maskFields(String[] fields) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<fields.length; i++) {
			System.out.println("[" + fields[i] + "]");
			
			int index = fields[i].indexOf("=");				
			String fieldName = fields[i].substring(0, index);
			String fieldValue = fields[i].substring(index+1);			
	
			sb.append(fieldName + "=" + fieldValue + '\u0001');
		}
		
		return sb.toString();
	}
}
