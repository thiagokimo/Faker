package io.kimo.lib.faker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.kimo.lib.faker.component.FakerColorComponent;
import io.kimo.lib.faker.component.FakerNumericComponent;
import io.kimo.lib.faker.component.FakerTextComponent;
import io.kimo.lib.faker.component.number.ColorComponent;
import io.kimo.lib.faker.component.number.NumberComponent;
import io.kimo.lib.faker.component.text.InternetComponent;
import io.kimo.lib.faker.component.text.LoremComponent;
import io.kimo.lib.faker.component.text.NameComponent;
import io.kimo.lib.faker.component.text.PhoneComponent;
import io.kimo.lib.faker.component.text.UrlComponent;

public class FakerProvider {

    public static LoremComponent Lorem;
    public static NameComponent Name;
    public static NumberComponent Number;
    public static PhoneComponent Phone;
    public static InternetComponent Internet;
    public static UrlComponent Url;
    public static ColorComponent Color;

    public FakerProvider(Context context) {
        Lorem = new LoremComponent(context);
        Name = new NameComponent(context);
        Number = new NumberComponent(context);
        Phone = new PhoneComponent(context);
        Internet = new InternetComponent(context);
        Url = new UrlComponent(context);
        Color = new ColorComponent(context);
    }

    /**
     * Fill view with random data
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
            } else if(view instanceof TextView) {
                fillWithText((TextView)view, Lorem);
            } else if(view instanceof ImageView) {
                fillWithColor((ImageView)view, Color);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public void fillWithColor(ImageView view, FakerColorComponent component) {
        validateNotNullableView(view);
        validateIfIsATextView(view);
        validateNotNullableFakerComponent(component);

        view.setBackgroundColor(component.randomColor());
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
}
