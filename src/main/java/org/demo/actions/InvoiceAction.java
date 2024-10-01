package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.demo.actions.beans.InvoiceBean;

public class InvoiceAction extends ActionSupport  {

    InvoiceBean invoiceBean;

    @Override
    public String execute() throws Exception {
        System.out.println("execute!!");
        System.out.println("Asunto: " + invoiceBean.getSubject());
        System.out.println("Importe Bruto: " + invoiceBean.getImporteBruto());
        System.out.println("Fecha Desde: " + invoiceBean.getDateFrom());
        System.out.println("Fecha Hasta: " + invoiceBean.getDateTo());

        // Calcular el importe con IVA
        if (invoiceBean.getImporteBruto() != null) {
            double iva = 0.21; // 21% de IVA
            double importeConIVA = invoiceBean.getImporteBruto() * (1 + iva);
            invoiceBean.setImporteConIVA(importeConIVA);
        }

        return SUCCESS;
    }

    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;
    }

    @Override
    public void validate() {
        if (invoiceBean.getSubject().isEmpty()) {
            addFieldError("invoiceBean.subject", "El concepto es obligatorio.");
        }

        // Validar el importe bruto
        if (invoiceBean.getImporteBruto() == null || invoiceBean.getImporteBruto() <= 0) {
            addFieldError("invoiceBean.importeBruto", "El importe bruto debe ser mayor que cero.");
        }

        // Validar la fecha desde
        if (invoiceBean.getDateFrom() == null){
            addFieldError("invoiceBean.dateFrom()", "La fecha desde es obligatoria");
        }

        // Validar la fecha hasta
        if (invoiceBean.getDateTo() == null){
            addFieldError("invoiceBean.dateTo()", "La fecha hasta es obligatoria");
        }
    }


}
