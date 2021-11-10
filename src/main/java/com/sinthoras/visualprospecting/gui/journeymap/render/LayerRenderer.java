package com.sinthoras.visualprospecting.gui.journeymap.render;

import com.sinthoras.visualprospecting.gui.model.SupportedMap;
import com.sinthoras.visualprospecting.gui.model.layers.LayerManager;
import com.sinthoras.visualprospecting.gui.model.locations.ILocationProvider;
import journeymap.client.render.draw.DrawStep;

import java.util.ArrayList;
import java.util.List;

public abstract class LayerRenderer extends com.sinthoras.visualprospecting.gui.model.layers.LayerRenderer {

    protected List<DrawStep> drawSteps = new ArrayList<>();

    public LayerRenderer(LayerManager manager) {
        super(manager, SupportedMap.JourneyMap);
    }

    public List<? extends DrawStep> getDrawStepsCachedForInteraction() {
        return drawSteps;
    }

    public List<? extends DrawStep> getDrawStepsCachedForRendering() {
        return drawSteps;
    }

    @Override
    public void updateVisibleElements(List<? extends ILocationProvider> visibleElements) {
        drawSteps = (List<DrawStep>) mapLocationProviderToDrawStep(visibleElements);
    }

    protected abstract List<? extends DrawStep> mapLocationProviderToDrawStep(List<? extends ILocationProvider> visibleElements);
}