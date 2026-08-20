# Implementation Plan - Separate Movie and Series Pages

Split the current combined catalog into two distinct, full-screen pages for a more organized browsing experience.

## User Review Required

> [!IMPORTANT]
> The "Filmes" and "Séries" links in the Home screen header will now lead to their respective dedicated pages instead of a shared one.

- **Design**: Both pages will follow the Netflix grid layout with category-specific titles.
- **Navigation**: Dedicated "Back" buttons on each page to return to the Home screen.

## Proposed Changes

### Layouts
- **[MODIFY] [filmes.xml](file:///Users/senai/Downloads/netflix_ingrid/app/src/main/res/layout/filmes.xml)**:
    - Title: "Filmes".
    - Sections: "Filmes de Ação", "Lançamentos", etc.
    - Grid layout for posters.
    - Back button.
- **[NEW] [series.xml](file:///Users/senai/Downloads/netflix_ingrid/app/src/main/res/layout/series.xml)**:
    - Title: "Séries".
    - Sections: "Séries Premiadas", "Mais Vistas", etc.
    - Grid layout for posters.
    - Back button.

### Logic
- **[MODIFY] [MainActivity.java](file:///Users/senai/Downloads/netflix_ingrid/app/src/main/java/com/example/netflix_ingrid/MainActivity.java)**:
    - Remove `showCatalog()`.
    - Implement `showMoviesCatalog()` and `showSeriesCatalog()`.
    - Link `tv_series` and `tv_filmes` from `inicio.xml` to these new methods.
    - Update `onBackPressed` to handle returning from both new screens.

## Verification Plan

### Manual Verification
- Deploy the app.
- Click "Séries" at the top of the Home screen and verify it opens the Series-only page.
- Click "Filmes" and verify it opens the Movies-only page.
- Test the back button on both pages.
