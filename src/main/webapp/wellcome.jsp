<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
  <title><s:text name="hello.message"/></title>
  <s:head/>
  <sx:head/>
</head>

<body>

    <h1>Resumen de factura: </h1>
    <p><strong>Asunto:</strong> <s:property value="invoiceBean.subject" /></p>
    <p><strong>Importe Bruto:</strong> <s:property value="invoiceBean.importeBruto" /> €</p>
    <p><strong>Importe con IVA (21%):</strong> <s:property value="invoiceBean.importeConIVA" /> €</p>
    <p>IVA incluido en el importe.</p>

</body>
</html>