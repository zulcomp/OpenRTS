/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.battlefield.army.effects;

import geometry3D.Point3D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import tools.LogUtil;
import model.builders.EffectBuilder;
import model.battlefield.army.components.Projectile;
import model.battlefield.army.components.Unit;

/**
 *
 * @author Benoît
 */
public class LauncherEffect extends Effect implements ActionListener {
    protected final Projectile projectile;

    public LauncherEffect(Projectile projectile, ArrayList<EffectBuilder> effectBuilders, EffectSource source, EffectTarget target) {
        super(effectBuilders, source, target);
        this.projectile = projectile;
        projectile.addListener(this);
    }
    
    @Override
    public void launch(){
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(EffectBuilder eb : childEffectBuilders)
            eb.build(source, target, null).launch();
    }

}