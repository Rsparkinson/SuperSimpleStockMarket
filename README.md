<h1 style="text-align: left;">Super Simple Stock Market</h1>
<h4 style="text-align: left;">by Richard Parkinson&nbsp;</h4>
<hr />
<p style="text-align: left;">&nbsp;</p>
<p>Welcome to my solution to the &ldquo;Example Assignment &ndash; Super Simple Stock Market&rdquo;. &nbsp;All source and unit test is included here.</p>
<p>&nbsp;</p>
<p>Developed on</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Ubuntu Linux 15.10</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Atom editor 1.9.8</p>
<p>&nbsp;</p>
<p>Requirements</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Spring boot 1.4.0</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Apache Maven 3.3.3</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Java version "1.8.0_101"</p>
<p>&nbsp;</p>
<p>Unit testing can be run with the following command.</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; mvn clean package</p>
<p>&nbsp;</p>
<p>To deploy as a web service. Run the following command.</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; mvn spring-boot:run</p>
<p>&nbsp;</p>
<p>Results can be views at this URL.</p>
<p><a href="http://127.0.0.1:8080/">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; http://127.0.0.1:8080/</a></p>
<p>&nbsp;</p>
<p>Example Results:</p>
<p><strong><span style="text-decoration: underline;">SuperSimpleStockMarket</span></strong></p>
<p><strong>Example Assignment &ndash; Super Simple Stock Market</strong></p>
<p><strong>Requirements</strong></p>
<p><strong>1. Provide working source code that will :-</strong></p>
<p><strong>i. Given any price as input, calculate the dividend yield</strong></p>
<p>Share GIN Price 123.65 dividend yield 0.016174687</p>
<p>&nbsp;</p>
<p><strong>ii. Given any price as input, calculate the P/E Ratio</strong></p>
<p>Share GIN Price 123.65 dividend yield 0.016174687 P/E Ratio 7644.661</p>
<p>&nbsp;</p>
<p><strong>iii. Record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price</strong></p>
<p>Trade records at 23/22/2016 19:22 Share POP Qty 120 Type buy Price 888.88</p>
<p>&nbsp;</p>
<p><strong>iv. Calculate Volume Weighted Stock Price based on trades in past 15 minutes</strong></p>
<p>id:1 symbol:TEA timeStamp:1471976522148 qty:10 type:buy tradePrice:12.12</p>
<p>id:2 symbol:GIN timeStamp:1471976522148 qty:107 type:buy tradePrice:1762.12</p>
<p>id:3 symbol:JOE timeStamp:1471976522148 qty:140 type:buy tradePrice:12.45</p>
<p>id:4 symbol:ALE timeStamp:1471976522148 qty:100 type:sell tradePrice:132.12</p>
<p>id:5 symbol:POP timeStamp:1471976522148 qty:120 type:buy tradePrice:888.88</p>
<p>Volume Weight Stock Price 650.5003</p>
<p>&nbsp;</p>
<p><strong>b. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks</strong></p>
<p>id:1 symbol:TEA timeStamp:1471976522148 qty:10 type:buy tradePrice:12.12</p>
<p>id:2 symbol:GIN timeStamp:1471976522148 qty:107 type:buy tradePrice:1762.12</p>
<p>id:3 symbol:JOE timeStamp:1471976522148 qty:140 type:buy tradePrice:12.45</p>
<p>id:4 symbol:ALE timeStamp:1471976522148 qty:100 type:sell tradePrice:132.12</p>
<p>id:5 symbol:POP timeStamp:1471976522148 qty:120 type:buy tradePrice:888.88</p>
<p>GBCE All Share Index 125.57519</p>
<p>&nbsp;</p>
