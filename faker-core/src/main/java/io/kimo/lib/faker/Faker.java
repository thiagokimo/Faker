package io.kimo.lib.faker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import io.kimo.lib.faker.component.FakerColorComponent;
import io.kimo.lib.faker.component.FakerNumericComponent;
import io.kimo.lib.faker.component.FakerTextComponent;
import io.kimo.lib.faker.component.number.ColorComponent;
import io.kimo.lib.faker.component.number.NumberComponent;
import io.kimo.lib.faker.component.text.AddressComponent;
import io.kimo.lib.faker.component.text.InternetComponent;
import io.kimo.lib.faker.component.text.LoremComponent;
import io.kimo.lib.faker.component.text.NameComponent;
import io.kimo.lib.faker.component.text.PhoneComponent;
import io.kimo.lib.faker.component.text.URLComponent;

public class Faker {

    private static Faker mFaker;

    public static LoremComponent Lorem;
    public static NameComponent Name;
    public static NumberComponent Number;
    public static PhoneComponent Phone;
    public static InternetComponent Internet;
    public static URLComponent Url;
    public static ColorComponent Color;
    public static AddressComponent Address;

    private HashSet<Integer> mIds = null;

    public static Faker with(Context context) {
        if(mFaker == null) {
            synchronized (Faker.class) {
                if(mFaker == null) {
                    mFaker = new Faker(context);
                }
            }
        }

        return mFaker;
    }

    /**
     * Configure all Faker components with a given context
     * @param context
     */
    private Faker(Context context) {
        Lorem = new LoremComponent(context);
        Name = new NameComponent(context);
        Number = new NumberComponent(context);
        Phone = new PhoneComponent(context);
        Internet = new InternetComponent(context);
        Url = new URLComponent(context);
        Color = new ColorComponent(context);
        Address = new AddressComponent(context);
    }

    /**
     * Fill a view with random data
     * @param view target view
     */
    public void fill(View view) {
        validateNotNullableView(view);

        try {
            if(view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for(int i = 0; i < viewGroup.getChildCount(); i++) {
                    View child = viewGroup.getChildAt(i);
                    fill(child);
                }
            } else {
                if(mIds == null) {
                    fillView(view);
                } else if(mIds.contains(view.getId())) {
                    fillView(view);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mFaker = null;
        }
    }

    /**
     * Fill a TextView with a specific FakerTextComponent
     * @param view
     * @param component
     */
    public void fillWithText(TextView view, FakerTextComponent component) {
        validateNotNullableView(view);
        validateIfIsATextView(view);
        validateNotNullableFakerComponent(component);

        view.setText(component.randomText());
    }

    /**
     * Specify with views are going to be filled with data.
     * @param ids - collection of ids
     */
    public Faker targetViews(Integer...ids) {
        mIds = new HashSet<>(Arrays.asList(ids));
        return this;
    }

    /**
     * Fill a TextView with a specific FakerNumericComponent
     * @param view
     * @param component
     */
    public void fillWithNumber(TextView view, FakerNumericComponent component) {
        validateNotNullableView(view);
        validateIfIsATextView(view);
        validateNotNullableFakerComponent(component);

        view.setText(String.valueOf(component.randomNumber()));
    }

    /**
     * Fill view with a random color
     * @param view
     * @param component
     */
    public void fillWithColor(View view, FakerColorComponent component) {
        validateNotNullableView(view);
        validateNotNullableFakerComponent(component);

        view.setBackgroundColor(component.randomColor());
    }

    /**
     * Set a random check or uncheck state
     * @param view
     */
    public void fillWithCheckState(CompoundButton view) {
        validateNotNullableView(view);
        validateIfIsACompoundButton(view);

        view.setChecked(new Random().nextBoolean());
    }

    /**
     * Fill {@link ToggleButton} on and off text
     * @param view
     * @param component
     */
    public void fillOnAndOffWithText(ToggleButton view, FakerTextComponent component) {
        validateNotNullableView(view);
        validateIfIsAToggleButton(view);
        validateNotNullableFakerComponent(component);

        String word = component.randomText();

        view.setTextOff(word);
        view.setTextOn(word);
    }

    /**
     * Fill a @{link ProgressBar} with a random progress
     * @param view
     * @param component
     */
    public void fillWithProgress(ProgressBar view, FakerNumericComponent component) {
        validateNotNullableView(view);
        validateIfIsAProgressBar(view);
        validateNotNullableFakerComponent(component);

        view.setProgress(Math.abs(component.randomNumber().intValue()));
    }

    private void fillView(View view) {
        if(view instanceof TextView) {
            if(view instanceof ToggleButton) {
                fillOnAndOffWithText((ToggleButton) view, Lorem);
            } else {
                fillWithText((TextView) view, Lorem);
            }
        }

        if(view instanceof CompoundButton) {
            fillWithCheckState((CompoundButton) view);
        }

        if(view instanceof ImageView) {
            fillWithColor(view, Color);
        }

        if(view instanceof ProgressBar) {
            fillWithProgress((ProgressBar) view, Number);
        }
    }

    private void validateIfIsACompoundButton(View view) {
        if(!(view instanceof CompoundButton))
            throw new IllegalArgumentException("View must be a CompoundButton");
    }

    private void validateIfIsATextView(View view) {
        if(!(view instanceof TextView))
            throw new IllegalArgumentException("View must be a TextView");
    }

    private void validateNotNullableView(View view) {
        if(view == null) {
            throw new IllegalArgumentException("View must not be null");
        }
    }

    private void validateNotNullableFakerComponent(FakerCoreComponent component) {
        if(component == null) {
            throw new IllegalArgumentException("FakerComponent must not be null");
        }
    }

    private void validateIfIsAToggleButton(View view) {
        if(!(view instanceof ToggleButton)) {
            throw new IllegalArgumentException("View must be a ToggleButton");
        }
    }

    private void validateIfIsAProgressBar(View view) {
        if(!(view instanceof ProgressBar)) {
            throw new IllegalArgumentException("View must be a ProgressBar");
        }
    }
}
