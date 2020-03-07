package com.company.erp.web.screens.cms.catalogproduct;

import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.cms.catalog_product.CatalogProduct;

import javax.inject.Inject;

@UiController("erp_CatalogProduct.browse")
@UiDescriptor("catalog-product-browse.xml")
@LookupComponent("catalogProductsTable")
@LoadDataBeforeShow
public class CatalogProductBrowse extends StandardLookup<CatalogProduct> {

    @Inject
    private UiComponents uiComponents;
    @Inject
    private GroupTable<CatalogProduct> catalogProductsTable;

    @Subscribe
    public void onInit(InitEvent event) {

        catalogProductsTable.addGeneratedColumn("image", catalogProduct -> {
            if (catalogProduct.getImage() != null) {
                Image productImage = uiComponents.create(Image.class);
                productImage.setScaleMode(Image.ScaleMode.SCALE_DOWN);
                productImage.setAlignment(Component.Alignment.MIDDLE_CENTER);
                productImage.setWidth("100%");
                productImage.setHeight("30px");

                productImage.setValueSource(new ContainerValueSource<>(catalogProductsTable.getInstanceContainer(catalogProduct), "image"));
                return productImage;
            }
            return null;
        });

    }


}