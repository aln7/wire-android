/**
 * Wire
 * Copyright (C) 2017 Wire Swiss GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.waz.zclient.pages.main.profile.preferences.pages

import android.content.{Context, Intent}
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.waz.zclient.pages.main.profile.preferences.views.TextButton
import com.waz.zclient.{R, ViewHelper}
import com.waz.zclient.utils.BackStackKey

class SupportView(context: Context, attrs: AttributeSet, style: Int) extends LinearLayout(context, attrs, style) with ViewHelper {
  def this(context: Context, attrs: AttributeSet) = this(context, attrs, 0)
  def this(context: Context) = this(context, null, 0)

  inflate(R.layout.preferences_support_layout)

  val websiteButton = findById[TextButton](R.id.settings_support_website)
  val contactButton = findById[TextButton](R.id.settings_support_contact)

  websiteButton.onClickEvent{ _ =>
    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.pref_support_website_url))))
  }

  contactButton.onClickEvent{ _ =>
    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.pref_support_contact_url))))
  }
}

case class SupportBackStackKey(args: Bundle = new Bundle()) extends BackStackKey(args) {
  override def nameId: Int = R.string.pref_support_screen_title

  override def layoutId = R.layout.preferences_support

  override def onViewAttached(v: View) = {}

  override def onViewDetached() = {}
}
