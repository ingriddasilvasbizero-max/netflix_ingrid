# Replace Back Arrows with Custom Drawable

The user wants to replace the current system back arrows (`@android:drawable/ic_menu_revert`) with a custom drawable (`@drawable/seta`) they saved.

## Proposed Changes

### UI Layouts

I will update the `android:src` attribute of the back buttons in the following layout files:

#### [MODIFY] [series.xml](file:///Users/senai/Desktop/netflix_ingrid/app/src/main/res/layout/series.xml)
- Update `btn_back_series` ImageButton to use `android:src="@drawable/seta"`.

#### [MODIFY] [filmes.xml](file:///Users/senai/Desktop/netflix_ingrid/app/src/main/res/layout/filmes.xml)
- Update `btn_back_movies` ImageButton to use `android:src="@drawable/seta"`.

#### [MODIFY] [minha_lista.xml](file:///Users/senai/Desktop/netflix_ingrid/app/src/main/res/layout/minha_lista.xml)
- Update `btn_back_my_list` ImageButton to use `android:src="@drawable/seta"`.

#### [MODIFY] [explorar.xml](file:///Users/senai/Desktop/netflix_ingrid/app/src/main/res/layout/explorar.xml)
- Update `btn_back_catalog` ImageButton to use `android:src="@drawable/seta"`.

## Verification Plan

### Manual Verification
- I will check the layout previews in Android Studio to ensure the new arrow drawable is correctly displayed on all screens.
- I will verify that the tint (`app:tint="@color/white"`) still applies correctly to the new drawable if applicable.
