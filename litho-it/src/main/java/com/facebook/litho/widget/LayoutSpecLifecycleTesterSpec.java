/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.litho.widget;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LifecycleStep;
import com.facebook.litho.LifecycleStep.StepInfo;
import com.facebook.litho.StateValue;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import java.util.List;

@LayoutSpec
class LayoutSpecLifecycleTesterSpec {

  @OnCreateInitialState
  static void onCreateInitialState(
      ComponentContext c, StateValue<String> state, @Prop List<LifecycleStep.StepInfo> steps) {
    steps.add(new StepInfo(LifecycleStep.ON_CREATE_INITIAL_STATE));
    state.set("hello world");
  }

  @OnCreateLayout
  static Component onCreateLayout(
      ComponentContext c, @Prop List<LifecycleStep.StepInfo> steps, @State String state) {
    steps.add(new StepInfo(LifecycleStep.ON_CREATE_LAYOUT));
    if (state == null) {
      throw new IllegalStateException("OnCreateLayout called without initialised state.");
    }
    return Column.create(c).build();
  }
}
