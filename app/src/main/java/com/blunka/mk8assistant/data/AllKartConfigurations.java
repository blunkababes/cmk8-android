package com.blunka.mk8assistant.data;

import com.blunka.mk8assistant.data.parts.PartData;
import com.blunka.mk8assistant.data.parts.PartGroup;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by clocksmith on 7/6/14.
 */
public class AllKartConfigurations {
  private List<KartConfiguration> mKartConfigurations;

  public AllKartConfigurations() {
    mKartConfigurations = Lists.newArrayList();
    for (PartGroup characterGroup : PartData.CHARACTER_GROUPS) {
      for (PartGroup vehicleGroup : PartData.VEHICLE_GROUPS) {
        for (PartGroup tireGroup : PartData.TIRE_GROUPS) {
          for (PartGroup gliderGroup : PartData.GLIDER_GROUPS) {
            mKartConfigurations.add(KartConfiguration.newBuilder()
                .withCharacterGroup(characterGroup)
                .withVehicleGroup(vehicleGroup)
                .withTireGroup(tireGroup)
                .withGliderGroup(gliderGroup)
                .build());
          }
        }
      }
    }
  }

  public List<KartConfiguration> getKartConfigurations() {
    return mKartConfigurations;
  }
}
