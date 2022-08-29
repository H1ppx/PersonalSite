package com.example.application.views.economics;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.io.filefilter.TrueFileFilter;

@PageTitle("Economics")
@Route(value = "econ", layout = MainLayout.class)
public class EconomicsView extends VerticalLayout {

    public EconomicsView() {
        setSpacing(false);

        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        add(new H2("Economics Calculators"));
        add(new Paragraph("Here lies some random calculators for economics, most of these are from Rutgers' Engineering " +
                "Economics course but I plan on continuing development on it as I try to tackle more economics classes"));

        Accordion accordion = new Accordion();
        accordion.add(breakEvenCalculator());
        accordion.add(powerSizingCalculator());
        accordion.add(pvfvCalculator());
        add(accordion);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    /***
     *  Calculates the break even quantity with the following parameters:
     *  Fixed Costs are costs that do not change with varying output (e.g., salary, rent, building machinery).
     *  Sales Price per Unit is the selling price (unit selling price) per unit.
     *  Variable Cost per Unit is the variable costs incurred to create a unit.
     */
    private AccordionPanel breakEvenCalculator(){

        TextField sellingPrice = new TextField();
        sellingPrice.setLabel("Selling Price");

        TextField variableCost = new TextField();
        variableCost.setLabel("Variable Cost");

        TextField fixedCost = new TextField();
        fixedCost.setLabel("Fixed Cost");

        TextField breakEvenQuantity = new TextField();
        breakEvenQuantity.setReadOnly(true);
        breakEvenQuantity.setLabel("Break-even Quantity");

        Button button = new Button("Calculate");
        button.addClickListener(event -> breakEvenQuantity.setValue(String.valueOf(
                Double.valueOf(fixedCost.getValue())/
                        (Double.valueOf(sellingPrice.getValue())
                        -Double.valueOf(variableCost.getValue())))));


        HorizontalLayout hLayout1 = new HorizontalLayout();
        hLayout1.setPadding(true);
        hLayout1.add(sellingPrice, variableCost, fixedCost);

        HorizontalLayout hLayout2 = new HorizontalLayout();
        hLayout2.setPadding(true);
        hLayout2.add(breakEvenQuantity);

        VerticalLayout vLayout = new VerticalLayout();
        vLayout.setPadding(true);
        vLayout.add(new Paragraph("Calculates the break even quantity where fixed Costs are costs that do not " +
                "change with varying output (e.g., salary, rent, building machinery). Sales Price per Unit is the " +
                "selling price (unit selling price) per unit. Variable Cost per Unit is the variable costs incurred to " +
                "create a unit."));
        vLayout.add(hLayout1);
        vLayout.add(hLayout2);
        vLayout.add(button);

        return new AccordionPanel("Break Even Quantity Calculator", vLayout);
    }

    //Todo add logic
    private AccordionPanel powerSizingCalculator(){

        TextField sizeA = new TextField();
        sizeA.setLabel("Size A");

        TextField sizeB = new TextField();
        sizeB.setLabel("Size B");

        TextField costA = new TextField();
        costA.setLabel("Cost A");

        TextField costB = new TextField();
        costB.setLabel("Cost B");

        TextField costCapacityFactor = new TextField();
        costCapacityFactor.setLabel("Cost Capacity Factor");

        Button button = new Button("Calculate");
        button.addClickListener(event -> System.out.println(true));


        HorizontalLayout hlayout1 = new HorizontalLayout();
        hlayout1.setPadding(true);
        hlayout1.add(sizeA, sizeB, costCapacityFactor, button);

        HorizontalLayout hlayout2 = new HorizontalLayout();
        hlayout2.setPadding(true);
        hlayout2.add(costA, costB, costCapacityFactor);

        VerticalLayout vLayout = new VerticalLayout();
        vLayout.setPadding(false);
        vLayout.add(new Paragraph("The 'power sizing model' of cost estimation is based on economies of scale. " +
                "It is used for estimating the cost of equipment and other industrial items. " +
                "Explanation: The known cost or price of a model commodity is either scaled up or are scaled-down " +
                "which results in economies of scale."));
        vLayout.add(hlayout1);
        vLayout.add(hlayout2);
        vLayout.add(button);

        return new AccordionPanel("Power Sizing Calculator", vLayout);
    }

    //Todo add logic
    private AccordionPanel pvfvCalculator(){

        TextField presentValue = new TextField();
        presentValue.setLabel("Present Value");

        TextField futureValue = new TextField();
        futureValue.setLabel("Future Value");

        TextField interestRate = new TextField();
        interestRate.setLabel("Interest Rate");

        TextField periods = new TextField();
        periods.setLabel("Number of Periods");

        Button button = new Button("Calculate");
        button.addClickListener(event -> System.out.println(true));


        HorizontalLayout hLayout1 = new HorizontalLayout();
        hLayout1.setPadding(true);
        hLayout1.add(presentValue, futureValue);

        HorizontalLayout hLayout2 = new HorizontalLayout();
        hLayout2.setPadding(true);
        hLayout2.add(interestRate, periods);

        VerticalLayout vLayout = new VerticalLayout();
        vLayout.setPadding(true);
        vLayout.add(new Paragraph("Calculates the present value, future value, interest rate or amount of periods " +
                "given the rest of the conditions are given"));
        vLayout.add(hLayout1);
        vLayout.add(hLayout2);
        vLayout.add(button);

        return new AccordionPanel("PV/FV Calculator for Lump Sums", vLayout);
    }
}
