package com.mohamedrejeb.richeditor.sample.common.slack

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun SlackDemoPanelButton(
    onClick: () -> Unit,
    icon: ImageVector,
    tint: Color? = null,
    enabled: Boolean = true,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            // Workaround to prevent the rich editor
            // from losing focus when clicking on the button
            // (Happens only on Desktop)
            .focusProperties { canFocus = false }
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            icon,
            contentDescription = icon.name,
            tint = tint ?: Color(0xFFCBCCCD),
            modifier = Modifier
                .background(
                    color = if (isSelected) Color(0xFF393B3D)
                    else Color.Transparent,
                )
                .padding(6.dp)
        )
    }
}