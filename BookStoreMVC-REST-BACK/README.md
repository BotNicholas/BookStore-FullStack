# Project Related info...
___

## `application.properties` file

---

`application.properties` file is not included so you have to specify it manually!!!
```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://ENTER_HERE_HOST:3306/ENTER_HERE_DB_NAME
spring.datasource.username=ENTER_HERE_USER
spring.datasource.password=ENTER_HERE_PASSWORD
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true

#FOR SWAGGER (is already connected)
springdoc.swagger-ui.path=/doc
springdoc.swagger-ui.operationsSorter=method
```
[How to connect MySQL to Spring boot here...](https://spring.io/guides/gs/accessing-data-mysql#_create_the_application_properties_file)

## Spring Boot version

---
In this project is used `Spring Boot v3.1.8`

## What is the difference between "simplicity" and "abstraction" mappers?

--- 

The main difference between `simplicity` and `abstraction`packages is that in the first one 
each entity has its own mapper, while in `abstratcion` package is defined only one implementation, that is generic
so it works for all the entities...

## Do not use ID on save!

---

ID is not expected to be used while saving new object, it is simple!

---

## Project Roles and access

---

In project are used only __three__ roles: `User`, `Manager` and `Admin`. <br>
See each roles duties and access below:

[//]: # (Created in Microsoft word...)
<table class="MsoTableGrid" border="1" cellspacing="0" cellpadding="0" align="left" style="border-collapse:collapse;border:none;mso-border-alt:solid windowtext .5pt;
 mso-yfti-tbllook:1184;mso-table-lspace:9.0pt;margin-left:6.75pt;mso-table-rspace:
 9.0pt;margin-right:6.75pt;mso-table-anchor-vertical:margin;mso-table-anchor-horizontal:
 margin;mso-table-left:left;mso-table-top:46.05pt;mso-padding-alt:0in 5.4pt 0in 5.4pt">
<thead style="mso-yfti-irow:0;mso-yfti-firstrow:yes; background-color: #4f4f4f;">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><b>Table<o:p></o:p></b></p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
  solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><b>Method<o:p></o:p></b></p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border:solid windowtext 1.0pt;
  border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
  solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><b>Role<o:p></o:p></b></p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border:solid windowtext 1.0pt;
  border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
  solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><b>Access <o:p></o:p></b></p>
  </td>
</thead>
<tbody style=" background-color: rgba(56,56,56,0.51);">
 </tr>
 <tr style="mso-yfti-irow:1">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Authors</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">User</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:2">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Authors</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CR</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Manager</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:3">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Authors</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CRUD</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Admin</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:4">
  <td width="623" colspan="4" valign="top" style="width:467.5pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:5">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Categories</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">User</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:6">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Categories</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Manager</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:7">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Categories</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CRUD</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Admin</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:8">
  <td width="623" colspan="4" valign="top" style="width:467.5pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:9">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Books</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">User</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:10">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Books</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CR</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Manager</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:11">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Books</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CRUD</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Admin</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:12">
  <td width="623" colspan="4" valign="top" style="width:467.5pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:13">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Contact types</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">-----</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">User</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:14">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Contact types</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Manager</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:15">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Contact types</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CRUD</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Admin</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:16">
  <td width="623" colspan="4" valign="top" style="width:467.5pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:17">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Contacts</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">-----</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">User</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:18">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Contacts</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Manager</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:19">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Contacts</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CRUD</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Admin</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:20">
  <td width="623" colspan="4" valign="top" style="width:467.5pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:21">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Costumer</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">RU</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">User</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">Self</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:22">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Costumer</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CR</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Manager</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:23">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Costumer</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CRUD</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Admin</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:24">
  <td width="623" colspan="4" valign="top" style="width:467.5pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:25">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Orders</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CR</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">User</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">Self</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:26">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Orders</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Manager</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:27">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Orders</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CRUD</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Admin</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:28">
  <td width="623" colspan="4" valign="top" style="width:467.5pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:29">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Order items</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">User</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">Self</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:30">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Order items</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Manager</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:31">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Order items</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CRUD</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Admin</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:32">
  <td width="623" colspan="4" valign="top" style="width:467.5pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly"><o:p>&nbsp;</o:p></p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:33">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Users</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">RU</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">User</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">Self</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:34">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Users</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">R</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Manager</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
 <tr style="mso-yfti-irow:35;mso-yfti-lastrow:yes">
  <td width="156" valign="top" style="width:116.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Users</p>
  </td>
  <td width="156" valign="top" style="width:116.85pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">CRUD</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" align="center" style="margin-bottom:0in;text-align:center;
  line-height:normal;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-horizontal:margin;mso-element-top:
  46.05pt;mso-height-rule:exactly">Admin</p>
  </td>
  <td width="156" valign="top" style="width:116.9pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0in 5.4pt 0in 5.4pt">
  <p class="MsoNormal" style="margin-bottom:0in;line-height:normal;mso-element:
  frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-horizontal:
  margin;mso-element-top:46.05pt;mso-height-rule:exactly">All, id</p>
  </td>
 </tr>
</tbody></table>

