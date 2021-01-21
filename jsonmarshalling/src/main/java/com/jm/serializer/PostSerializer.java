package com.jm.serializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jm.app.Post;

public class PostSerializer extends StdSerializer<Post> {

	public PostSerializer() {
		this(null);
	}

	public PostSerializer(Class<Post> t) {
		super(t);
	}

	@Override
	public void serialize(Post value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		ObjectNode[] objectNode = new ObjectMapper().readValue(value.getImagesJSON(), ObjectNode[].class);
		
		jgen.writeStartObject();
		jgen.writeStringField("userId", value.getUserId());
		jgen.writeObjectField("postedOn", value.getPostedOn());
		jgen.writeNumberField("postId", value.getPostId());
		jgen.writeArrayFieldStart("imageJson");
		
		for (ObjectNode node : objectNode) {
			Iterator<Entry<String, JsonNode>> fields = node.fields();
			jgen.writeStartObject();
			while (fields.hasNext()) {
				Entry<String, JsonNode> next = fields.next();
				JsonNode value2 = next.getValue();
				if (value2.isValueNode()) {
					ValueNode valueNode = (ValueNode) value2;
						if (valueNode instanceof TextNode) {
							jgen.writeStringField(next.getKey(), valueNode.asText());
						}else if ( valueNode instanceof IntNode) {

							jgen.writeNumberField(next.getKey(), valueNode.asInt());

						}
					
				}
			}
			jgen.writeEndObject();
		}
		jgen.writeEndArray();
		jgen.writeEndObject();
	}
}