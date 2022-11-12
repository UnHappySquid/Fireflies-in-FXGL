package com.Imad;


import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.*;
public class FliesFactory implements EntityFactory {

  @Spawns("fly")
  public Entity newFly(SpawnData data){
    double raduis = 10;

    if (data.getData().containsKey("radius")){
      raduis = data.get("radius");
    }

    return entityBuilder().with(new flyComponent(raduis)).build();
  }

  @Spawns("FG")
  public Entity newBG(SpawnData data){
    Rectangle myFG = new Rectangle(getAppWidth(),getAppWidth());
    myFG.setOpacity(0);
    myFG.setOnMouseMoved(e ->
    {
      flyComponent.aCenterX =  e.getSceneX();
      flyComponent.aCenterY = e.getSceneY();
    });
    myFG.setOnMouseClicked(e -> {
      flyComponent.aCenterX =  e.getSceneX();
      flyComponent.aCenterY = e.getSceneY();
      System.out.println("Clicked");
      System.out.println(e.getSceneX());
      System.out.println(e.getSceneY());
    });
    return entityBuilder().view(myFG).zIndex(1000).build();
  }



}
